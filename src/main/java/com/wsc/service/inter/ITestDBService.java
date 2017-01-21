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
    boolean createQuestion(int teacherId,Question question);

    void createQuestionList(int teacherId,List<Question> questions);

    Question deleteQuestion(int teacherId,int questionId);

    Question updateQuestion(int teacherId,int questionId,Question question);

    Question queryQuestion(int teacherId,int questionId);

    List<Question> queryQuestionByQuestionType(int teacherId,int questionType);

    List<Question> queryQuestionList(int teacherId,int fromQuestionId, int manyQuestionId);

    List<Question> queryQuestionListBySubject(int teacherId,int subjectId);

    File outPutQuestionBySubject(int subjectId);

    void inputQuesrtionByExcel(File file);

    /**
     * 试卷
     */

    boolean createPaper(int teacherId,Paper paper);

    void createPaperTemple1(int teacherId,String questionId);

    void createPaperTemple2(int teacherId,String questionId);

    void createPaperTemple3(int teacherId,String questionId);

    Paper deletePaper(int teacherId,int paperId);

    Paper updatePaper(int teacherId,int paperId,Paper paper);

    Paper queryPaper(int teacherId,int paperId);

    List<Paper> queryPaperList(int teacherId,int fromPaperId,int manyPaperId);

    List<Paper> queryPaperBySubjectId(int teacherId,int subjectId);

    File outputPaperByPaperId(int paperId);

    /**
     * 科目
     */
    boolean createSubject(int teacherId,Subject subject);

    Subject deleteSubject(int teacherId,int subjectId);

    Subject updateSubject(int teacherId,Subject subject);

    Subject querySubject(int teacherId,int subjectId);

    List<Subject> querySubjectList(int teacherId,int formSubjectId,int manySubjectId);


}
