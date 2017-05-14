package com.fm.service;

import com.fm.dto.ResultJson;
import com.fm.pojo.user.FmUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aiyi on 2017/5/6.
 */
public interface UserService {

    ResultJson login(String username, String password,
                     HttpServletRequest request, HttpServletResponse response);

    ResultJson register(FmUser user);

    ResultJson checkEmail(String email);

    ResultJson checkUsername(String username);

    ResultJson getUserByToken(String token);

    ResultJson getUserFm(Long uid);

}
