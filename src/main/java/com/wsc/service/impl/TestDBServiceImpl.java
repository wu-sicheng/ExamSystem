package com.wsc.service.impl;

import com.wsc.dao.inter.IManagerDao;
import com.wsc.dao.inter.IPaperDao;
import com.wsc.dao.inter.IQuestionDao;
import com.wsc.dao.inter.ISubjectDao;
import com.wsc.exceptions.ManagerException;
import com.wsc.exceptions.TestDBException;
import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.pojo.Subject;
import com.wsc.service.inter.IPersonService;
import com.wsc.service.inter.ITestDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by wsc on 17-1-21.
 */
@Service
public class TestDBServiceImpl implements ITestDBService{

    @Autowired
    private IPaperDao iPaperDao;

    @Autowired
    private IQuestionDao iQuestionDao;

    @Autowired
    private ISubjectDao iSubjectDao;

    @Autowired
    private IManagerDao iManagerDao;

    @Autowired
    private IPersonService iPersonService;

    private List<Integer> questionIdList;
    private List<Integer> paperIdList;

    /*
     * 试题
     */
    @Override
    public boolean createQuestion(int teacherId, Question question) {
        questionIdList=getQuestionIdList();
        if(iPersonService.createTestDB(teacherId)){
            if(!questionIdList.contains(question.getQuestionId())){
                iQuestionDao.createQuestion(question);
                return true;
            }
            else{
                throw new TestDBException("题库中已经存在该题目");
            }
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public void createQuestionList(int teacherId, List<Question> questions) {

    }

    @Override
    public Question deleteQuestion(int teacherId, int questionId) {
        return null;
    }

    @Override
    public Question updateQuestion(int teacherId, int questionId, Question question) {
        return null;
    }

    @Override
    public Question queryQuestion(int teacherId, int questionId) {
        return null;
    }

    @Override
    public List<Question> queryQuestionByQuestionType(int teacherId, int questionType) {
        return null;
    }

    @Override
    public List<Question> queryQuestionList(int teacherId, int fromQuestionId, int manyQuestionId) {
        return null;
    }

    @Override
    public List<Question> queryQuestionListBySubject(int teacherId, int subjectId) {
        return null;
    }

    @Override
    public File outPutQuestionBySubject(int subjectId) {
        return null;
    }

    @Override
    public void inputQuesrtionByExcel(File file) {

    }

    /**
     * 试卷
     *
     * @param teacherId
     * @param paper
     */
    @Override
    public boolean createPaper(int teacherId, Paper paper) {
        return false;
    }

    @Override
    public void createPaperTemple1(int teacherId, String questionId) {

    }

    @Override
    public void createPaperTemple2(int teacherId, String questionId) {

    }

    @Override
    public void createPaperTemple3(int teacherId, String questionId) {

    }

    @Override
    public Paper deletePaper(int teacherId, int paperId) {
        return null;
    }

    @Override
    public Paper updatePaper(int teacherId, int paperId, Paper paper) {
        return null;
    }

    @Override
    public Paper queryPaper(int teacherId, int paperId) {
        return null;
    }

    @Override
    public List<Paper> queryPaperList(int teacherId, int fromPaperId, int manyPaperId) {
        return null;
    }

    @Override
    public List<Paper> queryPaperBySubjectId(int teacherId, int subjectId) {
        return null;
    }

    @Override
    public File outputPaperByPaperId(int paperId) {
        return null;
    }

    /**
     * 科目
     *
     * @param teacherId
     * @param subject
     */
    @Override
    public boolean createSubject(int teacherId, Subject subject) {
        return false;
    }

    @Override
    public Subject deleteSubject(int teacherId, int subjectId) {
        return null;
    }

    @Override
    public Subject updateSubject(int teacherId, Subject subject) {
        return null;
    }

    @Override
    public Subject querySubject(int teacherId, int subjectId) {
        return null;
    }

    @Override
    public List<Subject> querySubjectList(int teacherId, int formSubjectId, int manySubjectId) {
        return null;
    }

    private List<Integer> getQuestionIdList(){
        return iQuestionDao.queryQuestionIdList();
    }
}
