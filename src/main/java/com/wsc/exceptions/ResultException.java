package com.wsc.exceptions;

/**
 * Created by wsc on 17-1-25.
 */
public class ResultException extends RuntimeException {
    public ResultException() {
    }

    public ResultException(String message) {
        super(message);
    }
}
