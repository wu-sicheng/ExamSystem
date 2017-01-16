package com.wsc.exceptions;

/**
 * Created by wsc on 17-1-16.
 */
public class ManagerException extends RuntimeException {
    public ManagerException() {
    }

    public ManagerException(String message) {
        super(message);
    }
}
