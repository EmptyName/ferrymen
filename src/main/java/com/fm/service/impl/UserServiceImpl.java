package com.fm.service.impl;

import com.fm.authority.token.Token;
import com.fm.authority.util.TokenManager;
import com.fm.dto.ResultJson;
import com.fm.exception.UserLoginFailException;
import com.fm.mapper.FmFlowerPropsLogMapper;
import com.fm.mapper.FmUserFmMapper;
import com.fm.mapper.FmUserMapper;
import com.fm.pojo.flower.FmFlowerPropsExample;
import com.fm.pojo.flower.FmFlowerPropsLog;
import com.fm.pojo.flower.FmFlowerPropsLogExample;
import com.fm.pojo.user.FmUser;
import com.fm.pojo.user.FmUserExample;
import com.fm.pojo.user.FmUserFm;
import com.fm.pojo.user.FmUserFmExample;
import com.fm.service.UserService;
import com.fm.util.CookieUtils;
import com.fm.util.IDUtils;
import com.fm.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by aiyi on 2017/5/6.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private FmUserMapper userMapper;

    @Autowired
    private FmUserFmMapper userFmMapper;

    @Autowired
    private TokenManager tokenManager;


    @Override
    public ResultJson login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        if (username == null || password == null) {
            throw new UserLoginFailException("账号或密码错误");
        }

        FmUserExample userExample = new FmUserExample();
        FmUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<FmUser> users = userMapper.selectByExample(userExample);

        if (users.size() == 0)
            throw new UserLoginFailException("账号或密码错误");

        CookieUtils.setCookie(request, response, "token", tokenManager.createToken(users.get(0).getId()).toString());
        return ResultJson.ok();
    }

    @Override
    @Transactional
    public ResultJson register(FmUser user) {
        long uid = IDUtils.genId();
        user.setId(uid);
        userMapper.insert(user);
        FmUserFm userFm = new FmUserFm();
        userFm.setId(IDUtils.genId());
        userFm.setUserId(uid);
        userFm.setUserFm(200);
        userFmMapper.insert(userFm);
        return ResultJson.build(201, "Created");
    }

    @Override
    public ResultJson checkEmail(String email) {
        FmUserExample userExample = new FmUserExample();
        FmUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<FmUser> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            return ResultJson.ok();
        } else {
            return ResultJson.build(409, "email has exist");
        }


    }

    @Override
    public ResultJson checkUsername(String username) {
        FmUserExample userExample = new FmUserExample();
        FmUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<FmUser> users = userMapper.selectByExample(userExample);

        if (users.size() == 0) {
            return ResultJson.ok();
        } else {
            return ResultJson.build(409, "username has exist");
        }
    }

    @Override
    public ResultJson getUserByToken(String token) {
        Token currentToken = tokenManager.getToken(token);
        if (currentToken == null) {
            return ResultJson.build(404, "token错误");
        }
        Long uid = currentToken.getUid();
        FmUser user = userMapper.selectByPrimaryKey(uid);
        if (user == null) {
            return ResultJson.build(404, "token已过期");
        }
        user.setUsername(null);
        user.setPassword(null);
        return ResultJson.ok(user);
    }


    public ResultJson getUserFm(Long uid) {
        FmUserFmExample userFmExample = new FmUserFmExample();
        FmUserFmExample.Criteria criteria = userFmExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<FmUserFm> fmUserFms = userFmMapper.selectByExample(userFmExample);
        return ResultJson.ok(fmUserFms.get(0).getUserFm());
    }


}
