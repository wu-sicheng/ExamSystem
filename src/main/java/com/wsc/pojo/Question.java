package com.wsc.pojo;

import java.util.Date;

/**
 * Created by wsc on 17-1-13.
 */
public class Question {
    private int questionId;
    private int subjectId;
    private String questionTitle;
    private String questionText;
    private String questionAnswer;
    private String questionRight;
    private double questionScore;
    private int questionType;
    private Date questionCreateTime;
    private Date questionDeleteTime;
    private int questionState;

    public Question() {
    }

    public Question(int questionId, int subjectId, String questionTitle, String questionText, String questionAnswer, String questionRight, double questionScore, int questionType, Date questionCreateTime, Date questionDeleteTime, int questionState) {
        this.questionId = questionId;
        this.subjectId = subjectId;
        this.questionTitle = questionTitle;
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
        this.questionRight = questionRight;
        this.questionScore = questionScore;
        this.questionType = questionType;
        this.questionCreateTime = questionCreateTime;
        this.questionDeleteTime = questionDeleteTime;
        this.questionState = questionState;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionRight() {
        return questionRight;
    }

    public void setQuestionRight(String questionRight) {
        this.questionRight = questionRight;
    }

    public double getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(double questionScore) {
        this.questionScore = questionScore;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public Date getQuestionCreateTime() {
        return questionCreateTime;
    }

    public void setQuestionCreateTime(Date questionCreateTime) {
        this.questionCreateTime = questionCreateTime;
    }

    public Date getQuestionDeleteTime() {
        return questionDeleteTime;
    }

    public void setQuestionDeleteTime(Date questionDeleteTime) {
        this.questionDeleteTime = questionDeleteTime;
    }

    public int getQuestionState() {
        return questionState;
    }

    public void setQuestionState(int questionState) {
        this.questionState = questionState;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", subjectId=" + subjectId +
                ", questionTitle='" + questionTitle + '\'' +
                ", questiontText='" + questionText + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionRight='" + questionRight + '\'' +
                ", questionScorce=" + questionScore +
                ", questionType=" + questionType +
                ", questionCreateTime=" + questionCreateTime +
                ", questionDeleteTime=" + questionDeleteTime +
                ", questionState=" + questionState +
                '}';
    }
}
