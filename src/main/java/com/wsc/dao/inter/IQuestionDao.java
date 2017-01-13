package com.wsc.dao.inter;

import com.wsc.pojo.Question;

/**
 * Created by wsc on 17-1-13.
 */
public interface IQuestionDao {
    boolean createQuestion(Question question);
    Question deleteQuestion(int questionId);
    Question updateQuestion(int questionId,Question question);
    Question queryQuestion(int questionId);
}
