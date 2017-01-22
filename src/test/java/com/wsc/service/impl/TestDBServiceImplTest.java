package com.wsc.service.impl;

import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.service.inter.ITestDBService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.ClientRequestInfoOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wsc on 17-1-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class TestDBServiceImplTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(TestDBServiceImplTest.class);

    @Resource
    private ITestDBService iTestDBService;

    @Test
    public void createQuestion() throws Exception {
        Question question=new Question(1,1,"question_title","question_text","question_answer","question_right",1,1,new Date(),new Date(),1);
        iTestDBService.createQuestion(4,question);
    }

    @Test
    public void createQuestionList() throws Exception {
        List<Question> questions=new ArrayList<>();
        questions.add(new Question(2,1,"question_title","question_text","question_answer","question_right",1,1,new Date(),new Date(),1));
        questions.add(new Question(3,1,"question_title","question_text","question_answer","question_right",1,1,new Date(),new Date(),1));
        iTestDBService.createQuestionList(4,questions);
    }

    @Test
    public void deleteQuestion() throws Exception {
        iTestDBService.deleteQuestion(4,1);
    }

    @Test
    public void updateQuestion() throws Exception {
        Question question=new Question(1,1,"question-change1231","question_text","question_answer","question_right",1,1,new Date(),new Date(),1);
        iTestDBService.updateQuestion(4,2,question);
    }

    @Test
    public void queryQuestion() throws Exception {
        Question question=iTestDBService.queryQuestion(4,1);
        LOGGER.info(question.toString());
    }

    @Test
    public void queryQuestionByQuestionType() throws Exception {
        List<Question> questions = iTestDBService.queryQuestionByQuestionType(4, 1);
        LOGGER.info(questions.toString());
    }
    @Test
    public void queryQuestionList() throws Exception {
        List<Question> questions=iTestDBService.queryQuestionList(4,1,3);
        LOGGER.info(questions.toString());
    }

    @Test
    public void queryQuestionListBySubject() throws Exception {
        List<Question> questions=iTestDBService.queryQuestionListBySubject(1,1);
        LOGGER.info(questions.toString());
    }

    @Test
    public void outPutQuestionBySubject() throws Exception {

    }

    @Test
    public void inputQuesrtionByExcel() throws Exception {

    }

    @Test
    public void createPaper() throws Exception {
        Paper paper=new Paper(1,"12",new Date(),new Date(),1,1,new Date(),new Date());
        iTestDBService.createPaper(4,paper);
    }

    @Test
    public void createPaperTemple1() throws Exception {

    }

    @Test
    public void createPaperTemple2() throws Exception {

    }

    @Test
    public void createPaperTemple3() throws Exception {

    }

    @Test
    public void deletePaper() throws Exception {

    }

    @Test
    public void updatePaper() throws Exception {

    }

    @Test
    public void queryPaper() throws Exception {

    }

    @Test
    public void queryPaperList() throws Exception {

    }

    @Test
    public void queryPaperBySubjectId() throws Exception {

    }

    @Test
    public void outputPaperByPaperId() throws Exception {

    }

    @Test
    public void createSubject() throws Exception {

    }

    @Test
    public void deleteSubject() throws Exception {

    }

    @Test
    public void updateSubject() throws Exception {

    }

    @Test
    public void querySubject() throws Exception {

    }

    @Test
    public void querySubjectList() throws Exception {

    }

}