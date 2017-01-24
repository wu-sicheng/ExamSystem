package com.wsc.dto;

import com.wsc.pojo.*;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by wsc on 17-1-24.
 */
public class Exam {
    private List<Student> students;
    private Paper paper;
    private List<Question> questions;
    private List<TheClass> theClasses;
    private Subject subject;
    private DateTime begin;
    private DateTime end;

    public Exam() {
    }

    public Exam(List<Student> students, Paper paper, List<Question> questions, List<TheClass> theClasses, Subject subject, DateTime begin, DateTime end) {
        this.students = students;
        this.paper = paper;
        this.questions = questions;
        this.theClasses = theClasses;
        this.subject = subject;
        this.begin = begin;
        this.end = end;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<TheClass> getTheClasses() {
        return theClasses;
    }

    public void setTheClasses(List<TheClass> theClasses) {
        this.theClasses = theClasses;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    @Override
    public String toString() {
        return "Exam{" +
                "students=" + students +
                ", paper=" + paper +
                ", questions=" + questions +
                ", theClasses=" + theClasses +
                ", subject=" + subject +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
