package com.wsc.service.inter;

import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.pojo.Subject;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-18.
 */
public interface ITestDBService {
    /**
     * 试题
     */
    Question createQuestion(Question question) throws IllegalAccessException;

    void createQuestionList(Set<Question> questions) throws IllegalAccessException;

    Question deleteQuestion(int questionId);

    Question updateQuestion(Question question);

    Question queryQuestion(int questionId);

    Set<Question> queryQuestionByQuestionType(int questionType);

    Set<Question> queryQuestionList(int fromQuestionId, int toQuestionId);

    Set<Question> queryQuestionAll();

    Set<Question> queryQuestionListBySubject(int subjectId);

    File outPutQuestionBySubject(int subjectId);

    void inputQuesrtionByExcel(File file);

    /**
     * 试卷
     */

    Paper createPaper(Paper paper) throws IllegalAccessException;

    void createPaperTemple1(String questionId);

    void createPaperTemple2(String questionId);

    void createPaperTemple3(String questionId);

    Paper deletePaper(int paperId);

    Paper updatePaper(Paper paper);

    Paper queryPaper(int paperId);

    Set<Paper> queryPaperList(int fromPaperId,int manyPaperId);

    Set<Paper> queryPaperAll();

    Set<Paper> queryPaperBySubjectId(int subjectId);

    File outputPaperByPaperId(int paperId);

    /**
     * 科目
     */
    Subject createSubject(Subject subject) throws IllegalAccessException;

    Subject deleteSubject(int subjectId);

    Subject updateSubject(Subject subject);

    Subject querySubject(int subjectId);

    Set<Subject> querySubjectList(int formSubjectId,int manySubjectId);

    Set<Subject> querySubjectAll();
}
