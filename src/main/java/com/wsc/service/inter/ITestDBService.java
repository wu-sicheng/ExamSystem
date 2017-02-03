package com.wsc.service.inter;

import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.pojo.Subject;

import java.io.File;
import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
public interface ITestDBService {
    /**
     * 试题
     */
    boolean createQuestion(Question question);

    void createQuestionList(List<Question> questions);

    Question deleteQuestion(int questionId);

    Question updateQuestion(int questionId,Question question);

    Question queryQuestion(int questionId);

    List<Question> queryQuestionByQuestionType(int questionType);

    List<Question> queryQuestionList(int fromQuestionId, int manyQuestionId);

    List<Question> queryQuestionListBySubject(int subjectId);

    File outPutQuestionBySubject(int subjectId);

    void inputQuesrtionByExcel(File file);

    /**
     * 试卷
     */

    boolean createPaper(Paper paper);

    void createPaperTemple1(String questionId);

    void createPaperTemple2(String questionId);

    void createPaperTemple3(String questionId);

    Paper deletePaper(int paperId);

    Paper updatePaper(int paperId,Paper paper);

    Paper queryPaper(int paperId);

    List<Paper> queryPaperList(int fromPaperId,int manyPaperId);

    List<Paper> queryPaperBySubjectId(int subjectId);

    File outputPaperByPaperId(int paperId);

    /**
     * 科目
     */
    boolean createSubject(Subject subject);

    Subject deleteSubject(int subjectId);

    Subject updateSubject(Subject subject);

    Subject querySubject(int subjectId);

    List<Subject> querySubjectList(int formSubjectId,int manySubjectId);


}
