package com.fm.controller.base;

import com.fm.dto.ResultJson;
import com.fm.exception.TokenException;
import com.fm.exception.UserHasNotEnoughFmException;
import com.fm.exception.UserNotFoundException;
import com.fm.exception.UserUnauthorizedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aiyi on 2017/5/2.
 */
@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(UserUnauthorizedException.class)
    public ResultJson handlerUserUnauthorizedException() {
        return ResultJson.build(403, "Unauthorized");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJson handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> res = new ArrayList<>(fieldErrors.size());
        for (FieldError fieldError : fieldErrors) {
            res.add(fieldError.getDefaultMessage());
        }
        return ResultJson.build(400, "数据绑定失败", res);
    }

    @ExceptionHandler(TokenException.class)
    public ResultJson handlerTokenException() {
        return ResultJson.build(400, "add 1s failure");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResultJson handlerUserNotFoundException() {
        return ResultJson.build(404, "用户不存在");
    }

    @ExceptionHandler(UserHasNotEnoughFmException.class)
    public ResultJson handlerUserHasNotEnoughFmException(UserHasNotEnoughFmException e) {
        return ResultJson.build(400,e.getLocalizedMessage());
    }

}
