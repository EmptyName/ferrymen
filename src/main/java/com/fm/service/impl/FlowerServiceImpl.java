package com.fm.service.impl;

import com.fm.consts.FlowerPropsDict;
import com.fm.dto.GiftObject;
import com.fm.dto.PropsNumDTO;
import com.fm.dto.ResultJson;
import com.fm.exception.UserHasNotEnoughFmException;
import com.fm.exception.UserNotFoundException;
import com.fm.mapper.FmFlowerDictMapper;
import com.fm.mapper.FmFlowerMapper;
import com.fm.mapper.FmFlowerPropsLogMapper;
import com.fm.mapper.FmFlowerPropsMapper;
import com.fm.mapper.FmOrderItemMapper;
import com.fm.mapper.FmOrderMapper;
import com.fm.mapper.FmOrderShippingMapper;
import com.fm.mapper.FmUserFmMapper;
import com.fm.pojo.flower.FmFlower;
import com.fm.pojo.flower.FmFlowerDict;
import com.fm.pojo.flower.FmFlowerDictExample;
import com.fm.pojo.flower.FmFlowerExample;
import com.fm.pojo.flower.FmFlowerProps;
import com.fm.pojo.flower.FmFlowerPropsExample;
import com.fm.pojo.flower.FmFlowerPropsLog;
import com.fm.pojo.flower.FmFlowerPropsLogExample;
import com.fm.pojo.order.FmOrder;
import com.fm.pojo.order.FmOrderItem;
import com.fm.pojo.order.FmOrderShipping;
import com.fm.pojo.user.FmUser;
import com.fm.pojo.user.FmUserFm;
import com.fm.pojo.user.FmUserFmExample;
import com.fm.service.FlowerService;
import com.fm.util.IDUtils;
import com.fm.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by aiyi on 2017/5/7.
 */
@Service
public class FlowerServiceImpl implements FlowerService {


    @Autowired
    private FmFlowerDictMapper flowerDictMapper;

    @Autowired
    private FmFlowerMapper flowerMapper;

    @Autowired
    private FmFlowerPropsMapper flowerPropsMapper;

    @Autowired
    private FmOrderMapper orderMapper;

    @Autowired
    private FmOrderItemMapper orderItemMapper;

    @Autowired
    private FmOrderShippingMapper orderShippingMapper;

    @Autowired
    private FmFlowerPropsLogMapper flowerPropsLogMapper;

    @Autowired
    private FmUserFmMapper userFmMapper;


    @Override
    public ResultJson getAllSeed() {
        FmFlowerDictExample flowerDictExample = new FmFlowerDictExample();
        List<FmFlowerDict> flowerDicts = flowerDictMapper.selectByExample(flowerDictExample);

        return ResultJson.ok(flowerDicts);

    }

    @Override
    @Transactional
    public ResultJson choose(Long id, FmUser user) {
        FmFlowerDict fmFlowerDict = flowerDictMapper.selectByPrimaryKey(id);
        if (fmFlowerDict == null) {
            return ResultJson.build(404, "花不存在");
        }


        FmFlowerExample flowerExample = new FmFlowerExample();
        FmFlowerExample.Criteria criteria = flowerExample.createCriteria();
        List<Long> allSeedWithPriceEqual0 = flowerDictMapper.getAllSeedWithPriceEqual0();
        criteria.andUserIdEqualTo(user.getId()).andFlowerIdIn(allSeedWithPriceEqual0);
        List<FmFlower> flowers = flowerMapper.selectByExample(flowerExample);
        for (FmFlower flower : flowers) {
            if (!isMature(flower) && isEqual0(allSeedWithPriceEqual0, id)) {
                return ResultJson.build(409, "已有免费花且未成熟");
            }
        }
        FmFlower currentFlower = new FmFlower();
        currentFlower.setId(IDUtils.genId());
        currentFlower.setFlowerId(id);
        currentFlower.setUserId(user.getId());
        flowerMapper.insert(currentFlower);
        cost(user.getId(), fmFlowerDict.getPrice());
        return ResultJson.ok();
    }

    @Override
    public ResultJson getAllProps() {
        FmFlowerPropsExample fmFlowerPropsExample = new FmFlowerPropsExample();
        List<FmFlowerProps> fmFlowerProps = flowerPropsMapper.selectByExample(fmFlowerPropsExample);
        return ResultJson.ok(fmFlowerProps);

    }

    @Override
    @Transactional
    public ResultJson useProps(Long id, FmUser user) {
        FmFlowerProps fmFlowerProps = flowerPropsMapper.selectByPrimaryKey(id);
        if (fmFlowerProps == null) {
            return ResultJson.build(404, "未找到该道具");
        }

        PropsNumDTO userPropsNum = getUserPropsNum(user.getId());
        if (!userPropsNum.canUse(id)) {
            return ResultJson.build(400, "已达今日上限制");
        }

        FmFlowerExample flowerExample = new FmFlowerExample();
        FmFlowerExample.Criteria criteria = flowerExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<FmFlower> flowers = flowerMapper.selectByExample(flowerExample);
        if (flowers.size() == 0) {
            return ResultJson.build(400, "糟糕的请求");
        }
        for (FmFlower flower : flowers) {
            use(flower, fmFlowerProps);
            flowerMapper.updateByPrimaryKey(flower);
        }
        FmFlowerPropsLog flowerPropsLog = new FmFlowerPropsLog();
        flowerPropsLog.setId(IDUtils.genId());
        flowerPropsLog.setPropsId(id);
        flowerPropsLog.setUserId(user.getId());
        flowerPropsLog.setUseTime(new Date());
        flowerPropsLogMapper.insert(flowerPropsLog);
        cost(user.getId(), fmFlowerProps.getPrice());
        return ResultJson.ok();
    }

    @Override
    public ResultJson gift(GiftObject giftObject, FmUser user) {
        long orderId = IDUtils.genId();
        long orderShippingId = IDUtils.genId();

        FmOrder order = new FmOrder();
        order.setId(orderId);
        order.setUserId(user.getId());
        order.setShippingId(orderShippingId);
        order.setMessage(giftObject.getMessage());
        order.setPostfee(giftObject.getPostFee());

        FmOrderShipping orderShipping = giftObject.getOrderShipping();
        orderShipping.setId(orderShippingId);
        orderShipping.setOrderId(orderId);


        orderShippingMapper.insert(orderShipping);
        insertOrderItem(giftObject.getOrderItems(), orderId);
        orderMapper.insert(order);
        return ResultJson.ok();
    }

    @Override
    public ResultJson getFlowerById(Long id) {
        FmFlower flower = flowerMapper.selectByPrimaryKey(id);
        if (flower == null) {
            return ResultJson.build(404, "id不存在");
        } else {
            return ResultJson.ok(flower);
        }
    }

    @Override
    public ResultJson getFlowerDictById(Long id) {
        FmFlowerDict fmFlowerDict = flowerDictMapper.selectByPrimaryKey(id);
        if (fmFlowerDict == null) {
            return ResultJson.build(404, "该种花不存在");
        }

        return ResultJson.ok(fmFlowerDict);
    }

    @Override
    public ResultJson getAllFlower(Long uid) {
        FmFlowerExample flowerExample = new FmFlowerExample();
        FmFlowerExample.Criteria criteria = flowerExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<FmFlower> flowers = flowerMapper.selectByExample(flowerExample);
        return ResultJson.ok(flowers);
    }

    @Override
    public ResultJson getPropsNum(Long uid) {
        PropsNumDTO propsNumDTO = getUserPropsNum(uid);
        return ResultJson.ok(propsNumDTO);
    }


    private boolean isMature(FmFlower flower) {
        return flower.getGrowth() + flower.getQuality()
                + flower.getSunshine() + flower.getThriving() >= 1000;
    }

    private boolean isEqual0(List<Long> list, Long id) {
        for (Long i : list) {
            if (i.equals(id)) {
                return true;
            }
        }
        return false;
    }

    private void use(FmFlower flower, FmFlowerProps props) {
        switch (props.getCategory()) {
            case "成长值":
                flower.setGrowth(flower.getGrowth() + props.getAttribute());
                break;
            case "品质值":
                flower.setQuality(flower.getQuality() + props.getAttribute());
                break;
            case "茁壮值":
                flower.setThriving(flower.getThriving() + props.getAttribute());
                break;
            case "阳光值":
                flower.setSunshine(flower.getSunshine() + props.getAttribute());
                break;
            default:
                throw new RuntimeException("道具属性错误");
        }


    }

    private void insertOrderItem(List<FmOrderItem> orderItems, Long orderId) {
        for (FmOrderItem orderItem : orderItems) {
            orderItem.setId(IDUtils.genId());
            orderItem.setOrderId(orderId);
            orderItemMapper.insert(orderItem);
        }

    }


    private PropsNumDTO getUserPropsNum(Long uid) {
        Date date = new Date();
        Date yesterday = TimeUtil.getToday(date);
        Date current = TimeUtil.getTomorrow(date);
        int irrigation = 0;
        int weeding = 0;
        int insecticide = 0;
        int illumination = 0;
        int fertilization = 0;

        FmFlowerPropsLogExample flowerPropsLogExample = new FmFlowerPropsLogExample();
        FmFlowerPropsLogExample.Criteria criteria = flowerPropsLogExample.createCriteria();
        criteria.andUserIdEqualTo(uid).andUseTimeBetween(yesterday, current).andPropsIdEqualTo(FlowerPropsDict.IRRIGATION);
        List<FmFlowerPropsLog> fmFlowerPropsLogs = flowerPropsLogMapper.selectByExample(flowerPropsLogExample);
        irrigation = FlowerPropsDict.IRRIGATION_TOTAL - fmFlowerPropsLogs.size();


        flowerPropsLogExample = new FmFlowerPropsLogExample();
        criteria = flowerPropsLogExample.createCriteria();
        criteria.andUserIdEqualTo(uid).andUseTimeBetween(yesterday, current).andPropsIdEqualTo(FlowerPropsDict.WEEDING);
        List<FmFlowerPropsLog> fmFlowerPropsLogs1 = flowerPropsLogMapper.selectByExample(flowerPropsLogExample);
        weeding = FlowerPropsDict.WEEDING_TOTAL - fmFlowerPropsLogs1.size();


        flowerPropsLogExample = new FmFlowerPropsLogExample();
        criteria = flowerPropsLogExample.createCriteria();
        criteria.andUserIdEqualTo(uid).andUseTimeBetween(yesterday, current).andPropsIdEqualTo(FlowerPropsDict.INSECTICIDE);
        List<FmFlowerPropsLog> fmFlowerPropsLogs2 = flowerPropsLogMapper.selectByExample(flowerPropsLogExample);
        insecticide = FlowerPropsDict.INSECTICIDE_TOTAL - fmFlowerPropsLogs2.size();


        flowerPropsLogExample = new FmFlowerPropsLogExample();
        criteria = flowerPropsLogExample.createCriteria();
        criteria.andUserIdEqualTo(uid).andUseTimeBetween(yesterday, current).andPropsIdEqualTo(FlowerPropsDict.ILLUMINATION);
        List<FmFlowerPropsLog> fmFlowerPropsLogs3 = flowerPropsLogMapper.selectByExample(flowerPropsLogExample);
        illumination = FlowerPropsDict.ILLUMINATION_TOTAL - fmFlowerPropsLogs3.size();

        flowerPropsLogExample = new FmFlowerPropsLogExample();
        criteria = flowerPropsLogExample.createCriteria();
        criteria.andUserIdEqualTo(uid).andUseTimeBetween(yesterday, current).andPropsIdEqualTo(FlowerPropsDict.FERTILIZATION);
        List<FmFlowerPropsLog> fmFlowerPropsLogs4 = flowerPropsLogMapper.selectByExample(flowerPropsLogExample);
        fertilization = FlowerPropsDict.FERTILIZATION_TOTAL - fmFlowerPropsLogs4.size();


        PropsNumDTO propsNumDTO = new PropsNumDTO();
        propsNumDTO.setFreeProps(PropsNumDTO.createFreeProps(irrigation, weeding, insecticide, illumination));
        propsNumDTO.setChargeProps(PropsNumDTO.createChargeProps(fertilization));

        return propsNumDTO;
    }

    private void cost(Long uid, Integer price) {
        FmUserFmExample userFmExample = new FmUserFmExample();
        FmUserFmExample.Criteria criteria = userFmExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<FmUserFm> fmUserFms = userFmMapper.selectByExample(userFmExample);
        if (fmUserFms.size() == 0) {
            throw new UserNotFoundException("用户不存在");
        }
        FmUserFm userFm = fmUserFms.get(0);
        if (userFm.getUserFm() < price) {
            throw new UserHasNotEnoughFmException("fm豆不够");
        }

        userFm.setUserFm(userFm.getUserFm() - price);
        userFmMapper.updateByPrimaryKey(userFm);
    }
}
