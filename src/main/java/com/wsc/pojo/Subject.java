package com.wsc.pojo;

import java.util.Date;

/**
 * Created by wsc on 17-1-16.
 */
public class Subject {
    private int subjectId;
    private String subjectName;
    private Date subjectCreateTime;
    private Date subjectDeleteTime;
    private int subjectState;

    public Subject() {
    }

    public Subject(int subjectId, String subjectName, Date subjectCreateTime, Date subjectDeleteTime, int subjectState) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCreateTime = subjectCreateTime;
        this.subjectDeleteTime = subjectDeleteTime;
        this.subjectState = subjectState;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getSubjectCreateTime() {
        return subjectCreateTime;
    }

    public void setSubjectCreateTime(Date subjectCreateTime) {
        this.subjectCreateTime = subjectCreateTime;
    }

    public Date getSubjectDeleteTime() {
        return subjectDeleteTime;
    }

    public void setSubjectDeleteTime(Date subjectDeleteTime) {
        this.subjectDeleteTime = subjectDeleteTime;
    }

    public int getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(int subjectState) {
        this.subjectState = subjectState;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCreateTime=" + subjectCreateTime +
                ", subjectDeleteTime=" + subjectDeleteTime +
                ", subjectState=" + subjectState +
                '}';
    }
}
