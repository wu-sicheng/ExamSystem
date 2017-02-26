package com.wsc.service.impl;

import com.wsc.dao.inter.IManagerDao;
import com.wsc.dao.inter.IPaperDao;
import com.wsc.dao.inter.IQuestionDao;
import com.wsc.dao.inter.ISubjectDao;
import com.wsc.exceptions.ManagerException;
import com.wsc.exceptions.PersonException;
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
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    private Set<Integer> questionIdSet;
    private Set<Integer> paperIdSet;
    private Set<Integer> subjectIdSet;

    /*
     * 试题
     */

    @Override
    public Question createQuestion(Question question){
        int maxQuestionId= Collections.max(iQuestionDao.queryquestionIdSet());
        if(!judgeExistQuestion(question)) {
            question.setQuestionId(maxQuestionId + 1);
            try {
                if (!judgeQuestionNull(question)) {
                    iQuestionDao.createQuestion(question);
                    return question;
                } else {
                    LOGGER.info("create teacher中存在空值");
                    throw new PersonException("存储的数据存在空值");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else{
            LOGGER.info("数据库question中已存在数据为"+question.toString()+"的数据");
            throw new TestDBException("数据库question中已存在数据为"+question.toString()+"的数据");
        }
        return null;
    }

    @Override
    public void createQuestionList(Set<Question> questions) throws IllegalAccessException {
        Iterator<Question> questionIterator=questions.iterator();
        while(questionIterator.hasNext()){
            createQuestion(questionIterator.next());
        }
    }

    @Override
    public Question deleteQuestion(int questionId) {
        questionIdSet=getquestionIdSet();
        Question question=null;
        if(questionIdSet.contains(questionId)){
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
    public Question updateQuestion(Question question) {
        questionIdSet=getquestionIdSet();
        Question questionRe=null;
        if(questionIdSet.contains(question.getQuestionId())){
            questionRe=iQuestionDao.queryQuestion(question.getQuestionId());
            iQuestionDao.updateQuestion(question);
            return questionRe;
        }
        else{
            LOGGER.info("数据库question中没有id为:"+question.getQuestionId()+"的数据");
            throw new TestDBException("数据库question中没有id为:"+question.getQuestionId()+"的数据");
        }
    }

    @Override
    public Question queryQuestion(int questionId) {
        questionIdSet=getquestionIdSet();
        if(questionIdSet.contains(questionId)){
            return iQuestionDao.queryQuestion(questionId);
        }
        else{
            LOGGER.info("数据库question中没有questionId为"+questionId+"的数据");
            throw new TestDBException("数据库question中没有questionId为"+questionId+"的数据");
        }
    }

    @Override
    public Set<Question> queryQuestionByQuestionType(int questionType) {
        Set<Question> questions=null;
        questions=iQuestionDao.queryQuestionByQuestionType(questionType);
        if(questions!=null){
            return questions;
        }
        else{
            LOGGER.info("数据库question中没有questionType为"+questionType+"的数据");
            throw new TestDBException("数据库question中没有questionType为"+questionType+"的数据");
        }
    }

    @Override
    public Set<Question> queryQuestionList(int fromQuestionId, int toQuestionId) {
        Set<Question> questions=null;
        questions=iQuestionDao.queryQuestionList(fromQuestionId,toQuestionId);
        if(questions!=null){
            return questions;
        }
        else{
            LOGGER.info("数据库question中没有数据");
            throw new TestDBException("数据库question中没有数据");
        }
    }

    @Override
    public Set<Question> queryQuestionAll(){
        return queryQuestionList(Collections.min(iQuestionDao.queryquestionIdSet()),
                Collections.max(iQuestionDao.queryquestionIdSet()));
    }

    @Override
    public Set<Question> queryQuestionListBySubject(int subjectId) {
        Set<Question> questions=null;
        questions=iQuestionDao.queryQuestionBySubjectId(subjectId);
        if(questions!=null){
            return questions;
        }
        else{
            LOGGER.info("数据库question中没有subjectId为"+subjectId+"数据");
            throw new TestDBException("数据库question中没有subjectId为"+subjectId+"数据");
        }
    }

    @Override
    public File outPutQuestionBySubject(int subjectId) {
        return null;//TODO 文件下载
    }

    @Override
    public void inputQuesrtionByExcel(File file) {
        //TODO 文件上传
    }

    /*
     * 试卷
     */
    @Override
    public Paper createPaper(Paper paper) throws IllegalAccessException {
        int maxPaperId=Collections.max(iPaperDao.querypaperIdSet());
        if(!judgeExistPaper(paper)){
            paper.setPaperId(maxPaperId+1);
            if(!judgePaperNull(paper)){
                iPaperDao.createPaper(paper);
                return paper;
            }
            else{
                LOGGER.info("create paper中存在空值");
                throw new PersonException("存储的数据存在空值");
            }
        }
        else{
            LOGGER.info("数据库paper中已存在数据为"+paper.toString()+"的数据");
            throw new TestDBException("数据库paper中已存在数据为"+paper.toString()+"的数据");
        }
    }


    @Override
    public void createPaperTemple1(String questionId) {
        //TODO
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
        paperIdSet=getPaperIdSet();
        Paper paper=null;
        if(paperIdSet.contains(paperId)){
            paper=iPaperDao.queryPaper(paperId);
            iPaperDao.deletePaper(paperId);
            return paper;
        }
        else{
            LOGGER.info("数据库paper中不包含paperId为"+paperId+"条件的数据");
            throw new TestDBException("数据库paper中不包含paperId为"+paperId+"条件的数据");
        }
    }

    @Override //TODO //ERROR
    public Paper updatePaper(Paper paper) {
        paperIdSet=getPaperIdSet();
        Paper paperRe=null;
        if(paperIdSet.contains(paper.getPaperId())){
            paper=iPaperDao.queryPaper(paper.getPaperId());
            iPaperDao.updatePaper(paper);
            LOGGER.info("更新数据成功");
            return paper;
        }
        else{
            LOGGER.info("数据库paper中不包含paperId为"+paper.getPaperId()+"条件的数据");
            throw new TestDBException("数据库paper中不包含paperId为"+paper.getPaperId()+"条件的数据");
        }
    }

    @Override
    public Paper queryPaper(int paperId) {
        paperIdSet=getPaperIdSet();
        if(paperIdSet.contains(paperId)){
            return iPaperDao.queryPaper(paperId);
        }
        else{
            LOGGER.info("数据库paper中不包含paperId为"+paperId+"条件的数据");
            throw new TestDBException("数据库paper中不包含paperId为"+paperId+"条件的数据");
        }
    }

    @Override
    public Set<Paper> queryPaperList(int fromPaperId, int toPaperId) {
        Set<Paper> paperRe=iPaperDao.queryPaperList(fromPaperId,toPaperId);
        if(paperRe!=null){
            return paperRe;
        }
        else{
            LOGGER.info("数据库paper中没有文件");
            throw new TestDBException("数据库paper中没有文件");
        }
    }

    @Override //好消耗资源，要执行3次查询才完成方法
    public Set<Paper> queryPaperAll(){
        return queryPaperList(Collections.min(iPaperDao.querypaperIdSet()),
                Collections.max(iPaperDao.querypaperIdSet()));
    }

    @Override
    public Set<Paper> queryPaperBySubjectId(int subjectId) {
        Set<Paper> paperRe=iPaperDao.queryPaperBySubjectId(subjectId);
        if(paperRe !=null){
            return paperRe;
        }
        else {
            LOGGER.info("数据库paper中找不到subjectId为" + subjectId + "的数据");
            throw new TestDBException("数据库paper中找不到subjectId为" + subjectId + "的数据");
        }
    }

    @Override
    public File outputPaperByPaperId(int paperId) {
        return null; //Todo 文件下载
    }

    /**
     * 科目
     *
     * @param subject
     */
    @Override
    public Subject createSubject(Subject subject) throws IllegalAccessException {
        int maxSubjectId=Collections.max(iSubjectDao.querysubjectIdSet());
        if(!judgeExistSubject(subject)){
            subject.setSubjectId(maxSubjectId+1);
            if(!judgeSubjectNull(subject)){
                iSubjectDao.createSubject(subject);
                return subject;
            }
            else{
                LOGGER.info("create subject中存在空值");
                throw new TestDBException("create subject中存在空值");
            }
        }
        else{
            LOGGER.info("数据库subject中已存在数据为"+subject.toString()+"的数据");
            throw new TestDBException("数据库subject中已存在数据为"+subject.toString()+"的数据");
        }
    }

    @Override
    public Subject deleteSubject(int subjectId) {
        subjectIdSet=getsubjectIdSet();
        if(subjectIdSet.contains(subjectId)){
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
        subjectIdSet=getsubjectIdSet();
        if(subjectIdSet.contains(subject.getSubjectId())){
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
        subjectIdSet=getsubjectIdSet();
        if(subjectIdSet.contains(subjectId)){
            return iSubjectDao.querySubject(subjectId);
        }
        else{
            LOGGER.info("数据库subject中没有id为"+subjectId+"的数据");
            throw new TestDBException("数据库subject中没有id为"+subjectId+"的数据");
        }
    }

    @Override
    public Set<Subject> querySubjectList(int fromSubjectId, int toSubjectId) {
        Set<Subject> subjects=null;
        subjects=iSubjectDao.querySubjectList(fromSubjectId,toSubjectId);
        if(subjects != null){
            return subjects;
        }
        else{
            LOGGER.info("数据库subject找不到数据符合条件"+fromSubjectId+"到"+toSubjectId+"的数据");
            throw new TestDBException("数据库subject找不到数据符合条件"+fromSubjectId+"到"+toSubjectId+"的数据");
        }
    }

    public Set<Subject> querySubjectAll(){
        return querySubjectList(Collections.min(iSubjectDao.querysubjectIdSet()),
                Collections.max(iSubjectDao.querysubjectIdSet()));
    }

    private Set<Integer> getquestionIdSet(){
        return iQuestionDao.queryquestionIdSet();
    }

    private Set<Integer> getPaperIdSet(){
        return iPaperDao.querypaperIdSet();
    }

    private Set<Integer> getsubjectIdSet(){
        return iSubjectDao.querysubjectIdSet();
    }

    private boolean judgeExistQuestion(Question question){
        Set<String> questions=iQuestionDao.queryQuestionTitle();
        if(questions.contains(question.getQuestionTitle())){
            return true;
        }
        return false;
    }


    //TODO 没有测试过
    public boolean judgeQuestionNull(Question question) throws IllegalAccessException {
        for (Field f : question.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(question) == null) {
                return true;
            }
        }
        return false;
    }

    private boolean judgeExistPaper(Paper paper){
        Set<String> papers=iPaperDao.queryPaperName();
        if(papers.contains(paper.getPaperName())){
            return true;
        }
        return false;
    }

    //TODO 没有测试过
    public boolean judgePaperNull(Paper paper) throws IllegalAccessException {
        for (Field f : paper.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(paper) == null) {
                return true;
            }
        }
        return false;
    }

    private boolean judgeExistSubject(Subject subject){
        Set<String> subjectNames=iSubjectDao.querySubjectNames();
        if(subjectNames.contains(subject.getSubjectName())){
            return true;
        }
        return false;
    }

    //TODO 没有测试过
    private boolean judgeSubjectNull(Subject subject) throws IllegalAccessException {
        for (Field f : subject.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(subject) == null) {
                return true;
            }
        }
        return false;
    }
}
