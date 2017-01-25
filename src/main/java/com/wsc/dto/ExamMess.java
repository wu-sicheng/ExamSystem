package com.wsc.dto;

import org.joda.time.DateTime;

/**
 * Created by wsc on 17-1-24.
 */
public class ExamMess {
    private DateTime examBegin;
    private DateTime examEnd;
    private String paperName;
    private int paperId;

    public ExamMess() {
    }

    public ExamMess(DateTime examBegin, DateTime examEnd, String paperName, int paperId) {
        this.examBegin = examBegin;
        this.examEnd = examEnd;
        this.paperName = paperName;
        this.paperId = paperId;
    }

    public DateTime getExamBegin() {
        return examBegin;
    }

    public void setExamBegin(DateTime examBegin) {
        this.examBegin = examBegin;
    }

    public DateTime getExamEnd() {
        return examEnd;
    }

    public void setExamEnd(DateTime examEnd) {
        this.examEnd = examEnd;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    @Override
    public String toString() {
        return "ExamMess{" +
                "examBegin=" + examBegin +
                ", examEnd=" + examEnd +
                ", paperName='" + paperName + '\'' +
                ", paperId=" + paperId +
                '}';
    }
}
