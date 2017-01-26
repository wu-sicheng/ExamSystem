package com.wsc.pojo;

import java.util.Date;
/**
 * Created by wsc on 17-1-13.
 */
public class TheClass {
    private int theClassId;
    private int theClassState;
    private String theClassName;
    private Date theClassCreateTime;
    private Date theClassDeleteTime;

    public TheClass() {
    }

    public TheClass(int theClassId, int theClassState, String theClassName,Date theClassCreateTime,Date theClassDeleteTime) {
        this.theClassId = theClassId;
        this.theClassState = theClassState;
        this.theClassName = theClassName;
        this.theClassCreateTime=theClassCreateTime;
        this.theClassDeleteTime=theClassDeleteTime;
    }

    public int getTheClassId() {
        return theClassId;
    }

    public void setTheClassId(int theClassId) {
        this.theClassId = theClassId;
    }

    public int getTheClassState() {
        return theClassState;
    }

    public void setTheClassState(int theClassState) {
        this.theClassState = theClassState;
    }

    public String getTheClassName() {
        return theClassName;
    }

    public void setTheClassName(String theClassName) {
        this.theClassName = theClassName;
    }

    public Date getTheClassCreateTime() {
        return theClassCreateTime;
    }

    public void setTheClassCreateTime(Date theClassCreateTime) {
        this.theClassCreateTime = theClassCreateTime;
    }

    public Date getTheClassDeleteTime() {
        return theClassDeleteTime;
    }

    public void setTheClassDeleteTime(Date theClassDeleteTime) {
        this.theClassDeleteTime = theClassDeleteTime;
    }

    @Override
    public String toString() {
        return "TheClass{" +
                "theClassId=" + theClassId +
                ", theClassState=" + theClassState +
                ", theClassName='" + theClassName + '\'' +
                ", theClassCreateTime=" + theClassCreateTime +
                ", theClassDeleteTime=" + theClassDeleteTime +
                '}';
    }
}
