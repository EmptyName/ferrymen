package com.fm.controller.flower;

import com.fm.authority.annotion.AuthAnnotation;
import com.fm.authority.annotion.InjectUser;
import com.fm.dto.GiftObject;
import com.fm.dto.ResultJson;
import com.fm.pojo.user.FmUser;
import com.fm.service.FlowerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiyi on 2017/5/6.
 */
@RestController
@RequestMapping(value = "/fm/flower", produces = "application/json;charset=UTF-8")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @GetMapping("/getallseed")
    @ApiOperation(value = "返回所有种子")
    public ResultJson getAllSeed() {
        return flowerService.getAllSeed();
    }

    @GetMapping("/choose/{id}")
    @AuthAnnotation
    @ApiOperation(value = "选种",
            notes = "选收费花会扣fm豆的,支付过程没弄。。你前端处理下^_^  带cookie   测试注意框框下面的Parameter content type",
            consumes = "application/x-www-form-urlencoded")
    public ResultJson choose(@ApiParam(name = "id", value = "花的id", required = true)
            @PathVariable("id") Long id, @InjectUser FmUser user) {
        return flowerService.choose(id, user);
    }


    @GetMapping("/getallprops")
    @ApiOperation("获取所有的道具")
    public ResultJson getAllProps() {
        return flowerService.getAllProps();
    }

    @GetMapping("/useprops/{id}")
    @AuthAnnotation
    @ApiOperation(value = "使用道具",
            notes = "同选种一样处理的  带cookie   测试注意框框下面的Parameter content type", consumes = "application/x-www-form-urlencoded")
    public ResultJson useProps(@ApiParam(name = "id", value = "道具id", required = true)
            @PathVariable("id") Long id, @InjectUser FmUser user) {
        return flowerService.useProps(id, user);
    }

    @GetMapping("/getallflower")
    @AuthAnnotation
    @ApiOperation(value = "返回用户所有的花", notes = "带cookie")
    public ResultJson getAllFlowerByUser(@InjectUser FmUser user) {
        return flowerService.getAllFlower(user.getId());
    }

    @GetMapping("/getflower/{id}")
    @ApiOperation(value = "根据花的id返回花的生长情况", consumes = "application/x-www-form-urlencoded",
            notes = "测试注意框框下面的Parameter content type")
    public ResultJson getFlowerById(@ApiParam(name = "id", value = "花的id", required = true)
            @PathVariable("id") Long id) {
        return flowerService.getFlowerById(id);
    }

    @GetMapping("/getflowerdict/{id}")
    @ApiOperation(value = "根据花的flowerId返回花的名称等信息", consumes = "application/x-www-form-urlencoded",
            notes = "测试注意框框下面的Parameter content type")
    public ResultJson getFlowerDictById(@ApiParam(name = "id", value = "花的flowerID", required = true)
                                        @PathVariable("id") Long id) {
        return flowerService.getFlowerDictById(id);
    }

    @GetMapping("/getpropsnum")
    @AuthAnnotation
    @ApiOperation(value = "返回今日可用道具数量", notes = "带cookie")
    public ResultJson getPropsNum(@InjectUser FmUser user) {
        return flowerService.getPropsNum(user.getId());
    }

    @PostMapping("/gift")
    @AuthAnnotation
    @ApiOperation(value = "送礼物")
    public ResultJson gift(@RequestBody GiftObject giftObject, @InjectUser FmUser user) {
        return flowerService.gift(giftObject, user);
    }

}
