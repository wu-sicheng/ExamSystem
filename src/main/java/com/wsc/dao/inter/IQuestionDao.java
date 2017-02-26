package com.wsc.dao.inter;

import com.wsc.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * Created by wsc on 17-1-13.
 */
public interface IQuestionDao {
    /**
     * 创建一个问题
     * @param question 创建问题
     * @return 是否创建成功
     */
    void createQuestion(Question question);

    /**
     * 删一个问题，将state由1改为0，并添加删除时间
     * @param questionId 删除问题的id
     * @return 删除问题的详情
     */
    void deleteQuestion(int questionId);

    /**
     * 通过id更改一个问题
     * @param question 更改后的问题
     * @return 更改前的问题
     */
    void updateQuestion(Question question);

    /**
     * 通过questionId查询一个问题
     * @param questionId 问题的id
     * @return 问题详情
     */
    Question queryQuestion(int questionId);

    /**
     * 查询一个问题列表
     * @param fromQuestionId 开始的id
     * @param toQuestionId 结束的id
     * @return 问题列表
     */
    Set<Question> queryQuestionList(@Param("fromQuestionId") int fromQuestionId,@Param("toQuestionId") int toQuestionId);

    Set<Integer> queryquestionIdSet();

    Set<Question> queryQuestionByQuestionType(int questionType);

    Set<Question> queryQuestionBySubjectId(int subjectId);

    Set<String> queryQuestionTitle();
}
