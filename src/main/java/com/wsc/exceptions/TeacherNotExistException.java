package com.wsc.exceptions;

/**
 * Created by wsc on 17-2-15.
 */
public class TeacherNotExistException extends PersonNotExistException {
    public TeacherNotExistException() {
    }

    public TeacherNotExistException(String message) {
        super(message);
    }
}
