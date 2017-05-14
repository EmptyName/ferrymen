package com.fm.controller.base;

import com.fm.authority.token.Token;
import com.fm.authority.util.TokenManager;
import com.fm.dto.ResultJson;
import com.fm.exception.TokenException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiyi on 2017/5/12.
 */
@RestController("/fm")
public class BaseController {


    @Autowired
    private TokenManager tokenManager;


    @GetMapping("/add1s/{token}")
    @ApiOperation(value = "token续命", consumes = "application/x-www-form-urlencoded",
        notes = "测试注意框框下面的Parameter content type")
    public ResultJson add1s(@ApiParam(value = "token", name = "token", required = true)
            @PathVariable String token) {
        try {
            tokenManager.add1s(tokenManager.getToken(token));
        } catch (Exception e) {
            throw new TokenException();
        }
        return ResultJson.ok();
    }


}
