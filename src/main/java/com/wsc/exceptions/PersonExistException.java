package com.wsc.exceptions;

/**
 * Created by wsc on 17-1-18.
 */
public class PersonExistException extends PersonException {
    public PersonExistException() {
    }
    public PersonExistException(String message) {
        super(message);
    }
}
