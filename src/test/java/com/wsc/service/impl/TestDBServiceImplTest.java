package com.wsc.service.impl;

import com.wsc.pojo.Question;
import com.wsc.service.inter.ITestDBService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by wsc on 17-1-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class TestDBServiceImplTest {

    @Resource
    private ITestDBService iTestDBService;

    @Test
    public void createQuestion() throws Exception {
        Question question=new Question(1,1,"question_title","question_text","question_answer","question_right",1,1,new Date(),new Date(),1);
        iTestDBService.createQuestion(4,question);
    }

    @Test
    public void createQuestionList() throws Exception {

    }

    @Test
    public void deleteQuestion() throws Exception {

    }

    @Test
    public void updateQuestion() throws Exception {

    }

    @Test
    public void queryQuestion() throws Exception {

    }

    @Test
    public void queryQuestionByQuestionType() throws Exception {

    }

    @Test
    public void queryQuestionList() throws Exception {

    }

    @Test
    public void queryQuestionListBySubject() throws Exception {

    }

    @Test
    public void outPutQuestionBySubject() throws Exception {

    }

    @Test
    public void inputQuesrtionByExcel() throws Exception {

    }

    @Test
    public void createPaper() throws Exception {

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