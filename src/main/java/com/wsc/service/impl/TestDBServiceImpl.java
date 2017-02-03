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
    private IPersonService iPersonService;

    private List<Integer> questionIdList;
    private List<Integer> paperIdList;
    private List<Integer> subjectIdList;

    /*
     * 试题
     */
    @Override
    public boolean createQuestion(Question question) {
        questionIdList=getQuestionIdList();
        if(!questionIdList.contains(question.getQuestionId())){
            iQuestionDao.createQuestion(question);
            return true;
        }
        else{
            throw new TestDBException("题库中已经存在该题目");
        }
    }

    @Override
    public void createQuestionList(List<Question> questions) {
        questionIdList=getQuestionIdList();
        for(int i=0;i<questions.size();i++){
            if(!questionIdList.contains(questions.get(i).getQuestionId())){
                iQuestionDao.createQuestion(questions.get(i));
            }
            else{
                LOGGER.info("题库中含有该题目:"+questions.get(i).toString());
            }
        }
    }

    @Override
    public Question deleteQuestion(int questionId) {
        questionIdList=getQuestionIdList();
        Question question=null;
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

    @Override
    public Question updateQuestion(int questionId, Question question) {
        questionIdList=getQuestionIdList();
        Question questionRe=null;
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

    @Override
    public Question queryQuestion(int questionId) {
        questionIdList=getQuestionIdList();
        if(questionIdList.contains(questionId)){
            return iQuestionDao.queryQuestion(questionId);
        }
        else{
            LOGGER.info("数据库中没有该数据");
            throw new TestDBException("数据库中没有该数据");
        }
    }

    @Override
    public List<Question> queryQuestionByQuestionType(int questionType) {
        List<Question> questions=null;
        questions=iQuestionDao.queryQuestionByQuestionType(questionType);
        try{
            if(questions.get(0)!=null){
                return questions;
            }
        }catch (IndexOutOfBoundsException e){
            LOGGER.info(e.getMessage());
            throw new TestDBException("找不到符合条件的数据");
        }
        return null;
    }

    @Override
    public List<Question> queryQuestionList(int fromQuestionId, int toQuestionId) {
        List<Question> questions=iQuestionDao.queryQuestionList(fromQuestionId,toQuestionId);
        return questions;
    }

    @Override
    public List<Question> queryQuestionListBySubject(int subjectId) {
        List<Question> questions=iQuestionDao.queryQuestionBySubjectId(subjectId);
        return questions;
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
    public boolean createPaper(Paper paper) {
        paperIdList=qetPapaerIdList();
        if(!paperIdList.contains(paper.getPaperId())){
            iPaperDao.createPaper(paper);
            return true;
        }
        else{
            LOGGER.info("数据库中含有该数据");
            throw new TestDBException("数据库中含有该数据");
        }
    }


    @Override
    public void createPaperTemple1(String questionId) {
        paperIdList=qetPapaerIdList();

    }

    @Override
    public void createPaperTemple2(String questionId) {
        //TODO
    }

    @Override
    public void createPaperTemple3(String questionId) {
        //TODO
    }

    @Override
    public Paper deletePaper(int paperId) {
        paperIdList=qetPapaerIdList();
        Paper paper=null;
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

    @Override //TODO //ERROR
    public Paper updatePaper(int paperId, Paper paper) {
        paperIdList=qetPapaerIdList();
        Paper paperRe=null;
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

    @Override
    public Paper queryPaper(int paperId) {
        paperIdList=qetPapaerIdList();
        if(paperIdList.contains(paperId)){
            return iPaperDao.queryPaper(paperId);
        }
        else{
            LOGGER.info("数据库中不包含符合条件的数据");
            throw new TestDBException("数据库中不包含符合条件的数据库");
        }
    }

    @Override
    public List<Paper> queryPaperList(int fromPaperId, int toPaperId) {
        List<Paper> paperRe=iPaperDao.queryPaperList(fromPaperId,toPaperId);
        try{
            if(paperRe.get(0)!=null){
                return paperRe;
            }
        }catch(IndexOutOfBoundsException e){
            LOGGER.info(e.getMessage());
            throw new TestDBException("没有符合条件的paper");
        }
        return null;
    }

    @Override
    public List<Paper> queryPaperBySubjectId(int subjectId) {
        List<Paper> paperRe=iPaperDao.queryPaperBySubjectId(subjectId);
        try{
            if(paperRe.get(0)!=null){
                return paperRe;
            }
        }catch(IndexOutOfBoundsException e){
            LOGGER.info(e.getMessage());
            throw new TestDBException("找不到符合条件的数据");
        }
        return null;
    }

    @Override
    public File outputPaperByPaperId(int paperId) {
        return null;
    }

    /**
     * 科目
     *
     * @param subject
     */
    @Override
    public boolean createSubject(Subject subject) {
        subjectIdList=getSubjectIdList();
        if(!subjectIdList.contains(subject.getSubjectId())){
            iSubjectDao.createSubject(subject);
            return true;
        }
        else{
            LOGGER.info("数据库subject中已经包含id为"+subject.getSubjectId()+"的数据");
            throw new TestDBException("数据库subject中已经包含id为"+subject.getSubjectId()+"的数据");
        }
    }

    @Override
    public Subject deleteSubject(int subjectId) {
        subjectIdList=getSubjectIdList();
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

    @Override
    public Subject updateSubject(Subject subject) {
        subjectIdList=getSubjectIdList();
        if(subjectIdList.contains(subject.getSubjectId())){
            Subject subjectRe=iSubjectDao.querySubject(subject.getSubjectId());
            iSubjectDao.updateSubject(subject);
            return subjectRe;
        }
        else{
            LOGGER.info("数据库subject中没有id为"+subject.getSubjectId()+"的数据");
            throw new TestDBException("数据库subject中没有id为"+subject.getSubjectId()+"的数据");
        }
    }

    @Override
    public Subject querySubject(int subjectId) {
        subjectIdList=getSubjectIdList();
        if(subjectIdList.contains(subjectId)){
            return iSubjectDao.querySubject(subjectId);
        }
        else{
            LOGGER.info("数据库subject中没有id为"+subjectId+"的数据");
            throw new TestDBException("数据库subject中没有id为"+subjectId+"的数据");
        }
    }

    @Override
    public List<Subject> querySubjectList(int fromSubjectId, int toSubjectId) {
        List<Subject> subjects=null;
        subjects=iSubjectDao.querySubjectList(fromSubjectId,toSubjectId);
        try{
            if(subjects.get(0)!=null){
                return subjects;
            }
        }catch (IndexOutOfBoundsException e){
            LOGGER.info(e.getMessage());
            throw new TestDBException("数据库subject找不到数据符合条件的数据");
        }
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
