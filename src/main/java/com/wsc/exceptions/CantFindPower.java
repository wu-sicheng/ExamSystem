package com.wsc.exceptions;

/**
 * Created by wsc on 17-1-16.
 */
public class CantFindPower extends RuntimeException{
    public CantFindPower() {
    }

    public CantFindPower(String message) {
        super(message);
    }
}
