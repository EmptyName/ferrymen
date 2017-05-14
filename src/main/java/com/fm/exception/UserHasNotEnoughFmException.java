package com.fm.exception;

/**
 * Created by aiyi on 2017/5/13.
 */
public class UserHasNotEnoughFmException extends RuntimeException {
    public UserHasNotEnoughFmException() {
    }

    public UserHasNotEnoughFmException(String message) {
        super(message);
    }

    public UserHasNotEnoughFmException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserHasNotEnoughFmException(Throwable cause) {
        super(cause);
    }
}
