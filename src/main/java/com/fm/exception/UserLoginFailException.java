package com.fm.exception;

/**
 * Created by aiyi on 2017/5/2.
 */
public class UserLoginFailException extends RuntimeException {

    public UserLoginFailException() {
    }

    public UserLoginFailException(String message) {
        super(message);
    }

    public UserLoginFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginFailException(Throwable cause) {
        super(cause);
    }
}
