package com.wsc.service.inter;

import com.wsc.pojo.Question;

import java.util.List;

/**
 * Created by wsc on 17-1-16.
 */
public interface IQuestionService {
    /**
     * 创建一个问题
     * @param question 创建问题
     * @return 是否创建成功
     */
    boolean createQuestion(Question question);

    /**
     * 删一个问题，将state由1改为0，并添加删除时间
     * @param questionId 删除问题的id
     * @return 删除问题的详情
     */
    Question deleteQuestion(int questionId);

    /**
     * 通过id更改一个问题
     * @param questionId question id
     * @param question 更改后的问题
     * @return 更改前的问题
     */
    Question updateQuestion(int questionId,Question question);

    /**
     * 通过questionId查询一个问题
     * @param questionId 问题的id
     * @return 问题详情
     */
    Question queryQuestion(int questionId);

    /**
     * 查询一个问题列表
     * @param fromQuestionId 开始的id
     * @param manyQuestionId 结束的id
     * @return 问题列表
     */
    List<Question> queryQuestionList(int fromQuestionId, int manyQuestionId);

    /**
     * 通过subjectid查询问题列表
     * @param subjectId subjectid
     * @return 问题列表
     */
    List<Question> queryQuestionBySubjectId(int subjectId);

    /**
     * 通过问题类型查询问题列表
     * @param questionType 问题类型
     * @return 问题列表
     */
    List<Question> queryQuestionByQuestionType(int questionType);

    /**
     * 判断题目是否删除
     * @param questionId question id
     * @return 是否删除
     */
    boolean isDelete(int questionId);

    /**
     * 通过分数加载问题列表
     * @param questionScorce
     * @return 问题列表
     */
    List<Question> queryQuestionByQuestionScorce(int questionScorce);
}
