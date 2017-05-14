package com.fm.controller.user;

import com.fm.authority.annotion.AuthAnnotation;
import com.fm.authority.annotion.InjectUser;
import com.fm.dto.ResultJson;
import com.fm.pojo.user.FmUser;
import com.fm.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by aiyi on 2017/5/2.
 */
@RestController
@RequestMapping("/fm/user")
@Api("用户相关接口")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "登陆", consumes = "application/x-www-form-urlencoded")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String", paramType = "form"),
    @ApiImplicitParam(name = "password", value = "密码", required = true,dataType = "String", paramType = "form")})
    public ResultJson login(String username, String password,
                            HttpServletRequest request, HttpServletResponse response) {
        return userService.login(username, password, request, response);
    }

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "注册", consumes = "application/json")
    @ApiImplicitParam(name = "user",value = "注册复杂DTO类", required = true)
    public ResultJson register(@RequestBody @Valid FmUser user) {
        return userService.register(user);
    }

    @GetMapping(value = "/checkemail/{email:.+}", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "检测邮箱是否重复", consumes = "application/x-www-form-urlencoded",
            notes = "测试注意框框下面的Parameter content type")
    public ResultJson checkEmail(@ApiParam(name = "email", value = "邮箱", required = true)
                                 @PathVariable(value = "email") String email) {

        return userService.checkEmail(email);
    }

    @GetMapping(value = "/checkusername/{username}", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "检测用户名是否重复", consumes = "application/x-www-form-urlencoded",
            notes = "测试注意框框下面的Parameter content type")
    public ResultJson checkUsername(@ApiParam(name = "username", value = "用户名", required = true)
                                    @PathVariable("username") String username) {
        return userService.checkUsername(username);
    }

    @GetMapping("/getuser/{token}")
    @ApiOperation(value = "根据token获取用户信息", consumes = "application/x-www-form-urlencoded",
            notes = "测试注意框框下面的Parameter content type")
    public ResultJson getUserByToken(@ApiParam(name = "token", value = "cookie里面的token", required = true)
                                     @PathVariable("token") String token) {
        return userService.getUserByToken(token);
    }


    @GetMapping("/getfm")
    @AuthAnnotation
    @ApiOperation(value = "获取当前用户的fm币", notes = "需要带有cookie")
    public ResultJson getFmByUser(@InjectUser FmUser user) {
        return userService.getUserFm(user.getId());
    }

}
