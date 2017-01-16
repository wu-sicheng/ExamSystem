package com.wsc.enums;

/**
 * Created by wsc on 17-1-16.
 */
public enum ExamState {
    BEFORE(-1,"考试没有开始"),EXAMING(0,"考试中"),AFTER(1,"考试结束");

    private int state;
    private String mean;

    ExamState(int state, String mean) {
        this.state = state;
        this.mean = mean;
    }
}
