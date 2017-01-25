package com.wsc.pojo;

import java.util.Date;

/**
 * Created by wsc on 17-1-13.
 */
public class Result {
    private int resultId;
    private int studentId;
    private int paperId;
    private int resultScorce;
    private String resultDetail;
    private Date resultCreateTime;
    private Date resultDeleteTime;
    private int resultState;

    public Result() {
    }

    public Result(int resultId, int studentId, int paperId, int resultScorce, String resultDetail, Date resultCreateTime, Date resultDeleteTime, int resultState) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.paperId = paperId;
        this.resultScorce = resultScorce;
        this.resultDetail = resultDetail;
        this.resultCreateTime = resultCreateTime;
        this.resultDeleteTime = resultDeleteTime;
        this.resultState = resultState;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getResultScorce() {
        return resultScorce;
    }

    public void setResultScorce(int resultScorce) {
        this.resultScorce = resultScorce;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public Date getResultCreateTime() {
        return resultCreateTime;
    }

    public void setResultCreateTime(Date resultCreateTime) {
        this.resultCreateTime = resultCreateTime;
    }

    public Date getResultDeleteTime() {
        return resultDeleteTime;
    }

    public void setResultDeleteTime(Date resultDeleteTime) {
        this.resultDeleteTime = resultDeleteTime;
    }

    public int getResultState() {
        return resultState;
    }

    public void setResultState(int resultState) {
        this.resultState = resultState;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", studentId=" + studentId +
                ", paperId=" + paperId +
                ", resultScorce=" + resultScorce +
                ", resultDetail='" + resultDetail + '\'' +
                ", resultCreateTime=" + resultCreateTime +
                ", resultDeleteTime=" + resultDeleteTime +
                ", resultState=" + resultState +
                '}';
    }
}
