package com.wsc.pojo;

import java.util.Date;

/**
 * Created by wsc on 17-1-13.
 */
public class Paper {
    private int paperId;
    private String paperName;
    private String questionId;
    private Date paperTimeBegin;
    private Date paperTimeEnd;
    private int subjectId;
    private int paperState;
    private Date createTime;
    private Date deleteTime;

    public Paper() {
    }

    public Paper(int paperId, String paperName,String questionId, Date paperTimeBegin, Date paperTimeEnd, int subjectId, int paperState, Date createTime, Date deleteTime) {
        this.paperId = paperId;
        this.questionId = questionId;
        this.paperName=paperName;
        this.paperTimeBegin = paperTimeBegin;
        this.paperTimeEnd = paperTimeEnd;
        this.subjectId = subjectId;
        this.paperState = paperState;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Date getPaperTimeBegin() {
        return paperTimeBegin;
    }

    public void setPaperTimeBegin(Date paperTimeBegin) {
        this.paperTimeBegin = paperTimeBegin;
    }

    public Date getPaperTimeEnd() {
        return paperTimeEnd;
    }

    public void setPaperTimeEnd(Date paperTimeEnd) {
        this.paperTimeEnd = paperTimeEnd;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getPaperState() {
        return paperState;
    }

    public void setPaperState(int paperState) {
        this.paperState = paperState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", questionId='" + questionId + '\'' +
                ", paperTimeBegin=" + paperTimeBegin +
                ", paperTimeEnd=" + paperTimeEnd +
                ", subjectId=" + subjectId +
                ", paperState=" + paperState +
                ", createTime=" + createTime +
                ", deleteTime=" + deleteTime +
                '}';
    }
}
