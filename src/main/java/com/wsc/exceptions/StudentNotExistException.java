package com.wsc.exceptions;

/**
 * Created by wsc on 17-2-15.
 */
public class StudentNotExistException extends PersonNotExistException {
    public StudentNotExistException() {
    }

    public StudentNotExistException(String message) {
        super(message);
    }
}
