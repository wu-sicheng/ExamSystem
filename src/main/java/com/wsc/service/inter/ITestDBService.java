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
    boolean createQuestion(int powerId,Question question);

    void createQuestionList(int powerId,List<Question> questions);

    Question deleteQuestion(int powerId,int questionId);

    Question updateQuestion(int powerId,int questionId,Question question);

    Question queryQuestion(int powerId,int questionId);

    List<Question> queryQuestionByQuestionType(int powerId,int questionType);

    List<Question> queryQuestionList(int powerId,int fromQuestionId, int manyQuestionId);

    List<Question> queryQuestionListBySubject(int powerId,int subjectId);

    File outPutQuestionBySubject(int subjectId);

    void inputQuesrtionByExcel(File file);

    /**
     * 试卷
     */

    boolean createPaper(int powerId,Paper paper);

    void createPaperTemple1(int powerId,String questionId);

    void createPaperTemple2(int powerId,String questionId);

    void createPaperTemple3(int powerId,String questionId);

    Paper deletePaper(int powerId,int paperId);

    Paper updatePaper(int powerId,int paperId,Paper paper);

    Paper queryPaper(int powerId,int paperId);

    List<Paper> queryPaperList(int powerId,int fromPaperId,int manyPaperId);

    List<Paper> queryPaperBySubjectId(int powerId,int subjectId);

    File outputPaperByPaperId(int paperId);

    /**
     * 科目
     */
    boolean createSubject(int powerId,Subject subject);

    Subject deleteSubject(int powerId,int subjectId);

    Subject updateSubject(int powerId,Subject subject);

    Subject querySubject(int powerId,int subjectId);

    List<Subject> querySubjectList(int powerId,int formSubjectId,int manySubjectId);


}
