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
import org.apache.ibatis.io.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by wsc on 17-1-21.
 */
@Service
public class TestDBServiceImpl implements ITestDBService{

    private static final Logger LOGGER= LoggerFactory.getLogger(TestDBServiceImpl.class);

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
    private List<Integer> subjectIdList;

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
        questionIdList=getQuestionIdList();
        if(iPersonService.createTestDB(teacherId)){
            for(int i=0;i<questions.size();i++){
                if(!questionIdList.contains(questions.get(i).getQuestionId())){
                    iQuestionDao.createQuestion(questions.get(i));
                }
                else{
                    LOGGER.info("题库中含有该题目:"+questions.get(i).toString());
                }
            }
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public Question deleteQuestion(int teacherId, int questionId) {
        questionIdList=getQuestionIdList();
        Question question=null;
        if(iPersonService.deleteTestDB(teacherId)){
            if(questionIdList.contains(questionId)){
                question=iQuestionDao.queryQuestion(questionId);
                iQuestionDao.deleteQuestion(questionId);
                return question;
            }
            else{
                LOGGER.info("question数据库中找不到id为"+questionId+"的数据");
                throw new TestDBException("question数据库中找不到id为"+questionId+"的数据");
            }
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public Question updateQuestion(int teacherId, int questionId, Question question) {
        questionIdList=getQuestionIdList();
        Question questionRe=null;
        if(iPersonService.updateTestDB(teacherId)){
            if(questionIdList.contains(questionId)){
                questionRe=iQuestionDao.queryQuestion(questionId);
                question.setQuestionId(questionId);
                iQuestionDao.updateQuestion(question);
                return questionRe;
            }
            else{
                LOGGER.info("数据库中没有id为:"+questionId+"的数据");
                throw new TestDBException("数据库中没有该数据");
            }
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public Question queryQuestion(int teacherId, int questionId) {
        questionIdList=getQuestionIdList();
        if(iPersonService.queryTestDB(teacherId)){
            if(questionIdList.contains(questionId)){
                return iQuestionDao.queryQuestion(questionId);
            }
            else{
                LOGGER.info("数据库中没有该数据");
                throw new TestDBException("数据库中没有该数据");
            }
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public List<Question> queryQuestionByQuestionType(int teacherId, int questionType) {
        List<Question> questions=null;
        if(iPersonService.queryTestDB(teacherId)){
            questions=iQuestionDao.queryQuestionByQuestionType(questionType);
            try{
                if(questions.get(0)!=null){
                    return questions;
                }
            }catch (IndexOutOfBoundsException e){
                LOGGER.info(e.getMessage());
                throw new TestDBException("找不到符合条件的数据");
            }
        }
        throw new ManagerException("没有权限");
    }

    @Override
    public List<Question> queryQuestionList(int teacherId, int fromQuestionId, int toQuestionId) {
        if(iPersonService.queryTestDB(teacherId)){
            List<Question> questions=iQuestionDao.queryQuestionList(fromQuestionId,toQuestionId);
            return questions;
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public List<Question> queryQuestionListBySubject(int teacherId, int subjectId) {
        if(iPersonService.queryTestDB(teacherId)){
            List<Question> questions=iQuestionDao.queryQuestionBySubjectId(subjectId);
            return questions;
        }
        else{
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public File outPutQuestionBySubject(int subjectId) {
        return null;//TODO
    }

    @Override
    public void inputQuesrtionByExcel(File file) {
        //TODO
    }

    /*
     * 试卷
     */
    @Override
    public boolean createPaper(int teacherId, Paper paper) {
        paperIdList=qetPapaerIdList();
        if(iPersonService.createTestDB(teacherId)){
            if(!paperIdList.contains(paper.getPaperId())){
                iPaperDao.createPaper(paper);
                return true;
            }
            else{
                LOGGER.info("数据库中含有该数据");
                throw new TestDBException("数据库中含有该数据");
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }


    @Override
    public void createPaperTemple1(int teacherId, String questionId) {
        paperIdList=qetPapaerIdList();
        if(iPersonService.createTestDB(teacherId)){
            //TODO
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public void createPaperTemple2(int teacherId, String questionId) {
        //TODO
    }

    @Override
    public void createPaperTemple3(int teacherId, String questionId) {
        //TODO
    }

    @Override
    public Paper deletePaper(int teacherId, int paperId) {
        paperIdList=qetPapaerIdList();
        Paper paper=null;
        if(iPersonService.deleteTestDB(teacherId)){
            if(paperIdList.contains(paperId)){
                paper=iPaperDao.queryPaper(paperId);
                iPaperDao.deletePaper(paperId);
                return paper;
            }
            else{
                LOGGER.info("数据库中不包含符合条件的数据");
                throw new TestDBException("数据库中不包含符合条件的数据库");
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }

    @Override //TODO //ERROR
    public Paper updatePaper(int teacherId, int paperId, Paper paper) {
        paperIdList=qetPapaerIdList();
        Paper paperRe=null;
        if(iPersonService.updateTestDB(teacherId)){
            if(paperIdList.contains(paperId)){
                paper=iPaperDao.queryPaper(paperId);
                paper.setPaperId(paperId);
                iPaperDao.updatePaper(paper);
                LOGGER.info("更新数据成功");
                return paper;
            }
            else{
                LOGGER.info("数据库中不包含符合条件的数据");
                throw new TestDBException("数据库中不包含符合条件的数据库");
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public Paper queryPaper(int teacherId, int paperId) {
        paperIdList=qetPapaerIdList();
        if(iPersonService.queryTestDB(teacherId)){
            if(paperIdList.contains(paperId)){
                return iPaperDao.queryPaper(paperId);
            }
            else{
                LOGGER.info("数据库中不包含符合条件的数据");
                throw new TestDBException("数据库中不包含符合条件的数据库");
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public List<Paper> queryPaperList(int teacherId, int fromPaperId, int toPaperId) {
        if(iPersonService.queryTestDB(teacherId)){
            List<Paper> paperRe=iPaperDao.queryPaperList(fromPaperId,toPaperId);
            try{
                if(paperRe.get(0)!=null){
                    return paperRe;
                }
            }catch(IndexOutOfBoundsException e){
                LOGGER.info(e.getMessage());
                throw new TestDBException("没有符合条件的paper");
            }
        }
        LOGGER.info("没有权限创建数据");
        throw new ManagerException("没有权限");
    }

    @Override
    public List<Paper> queryPaperBySubjectId(int teacherId, int subjectId) {
        if(iPersonService.queryTestDB(teacherId)){
            List<Paper> paperRe=iPaperDao.queryPaperBySubjectId(subjectId);
            try{
                if(paperRe.get(0)!=null){
                    return paperRe;
                }
            }catch(IndexOutOfBoundsException e){
                LOGGER.info(e.getMessage());
                throw new TestDBException("找不到符合条件的数据");
            }
        }
        LOGGER.info("没有权限创建数据");
        throw new ManagerException("没有权限");
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
        subjectIdList=getSubjectIdList();
        if(iPersonService.createTestDB(teacherId)){
            if(!subjectIdList.contains(subject.getSubjectId())){
                iSubjectDao.createSubject(subject);
                return true;
            }
            else{
                LOGGER.info("数据库subject中已经包含id为"+subject.getSubjectId()+"的数据");
                throw new TestDBException("数据库subject中已经包含id为"+subject.getSubjectId()+"的数据");
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }

    @Override
    public Subject deleteSubject(int teacherId, int subjectId) {
        subjectIdList=getSubjectIdList();
        if(iPersonService.createTestDB(teacherId)){
            if(subjectIdList.contains(subjectId)){
                Subject subject=iSubjectDao.querySubject(subjectId);
                iSubjectDao.deleteSubject(subjectId);
                return subject;
            }
            else{
                LOGGER.info("数据库subject中没有id为"+subjectId+"的数据");
                throw new TestDBException("数据库subject中没有id为"+subjectId+"的数据");
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
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

    private List<Integer> qetPapaerIdList(){
        return iPaperDao.queryPaperIdList();
    }

    private List<Integer> getSubjectIdList(){
        return iSubjectDao.querySubjectIdList();
    }
}
