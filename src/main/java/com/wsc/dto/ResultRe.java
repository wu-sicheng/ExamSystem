package com.wsc.dto;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by wsc on 17-1-26.
 */
public class ResultRe {
    private int studentId;
    private int paperId;
    private DateTime begin;
    private DateTime end;
    private List<QuestionRe> reList;

    public static class QuestionRe{
        private int questionId;
        private String answer;
        private double score;

        public QuestionRe() {
        }

        public QuestionRe(int questionId, String answer, double score) {
            this.questionId = questionId;
            this.answer = answer;
            this.score = score;
        }

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
}
