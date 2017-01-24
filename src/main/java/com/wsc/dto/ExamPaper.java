package com.wsc.dto;

import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by wsc on 17-1-24.
 */
public class ExamPaper {
    private DateTime begin;
    private DateTime end;
    private List<Question> questions;

    public ExamPaper() {
    }

    public ExamPaper(DateTime begin, DateTime end, List<Question> questions) {
        this.begin = begin;
        this.end = end;
        this.questions = questions;
    }

    public DateTime getBegin() {
        return begin;
    }

    public void setBegin(DateTime begin) {
        this.begin = begin;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "begin=" + begin +
                ", end=" + end +
                ", questions=" + questions +
                '}';
    }
}
