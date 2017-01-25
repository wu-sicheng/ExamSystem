package com.wsc.service.impl;

import com.wsc.dto.Exam;
import com.wsc.dto.ExamMess;
import com.wsc.dto.ExamPaper;
import com.wsc.service.inter.IExamService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wsc on 17-1-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class ExamServiceImplTest {
    private static final Logger LOGGER= LoggerFactory.getLogger(ExamServiceImplTest.class);

    @Resource
    private IExamService iExamService;

    @Test
    public void getExamPaper() throws Exception {
        ExamPaper examPaper=iExamService.getExamPaper(1,2);
        LOGGER.info(examPaper.toString());
    }

    @Test
    public void getExamMess() throws Exception{
        List<ExamMess> examMess=iExamService.getExamMess(7);
        LOGGER.info(examMess.toString());
    }

    @Test
    public void canExam() throws Exception{
        boolean b=iExamService.canExam(7,2);
        LOGGER.info(String.valueOf(b));
    }
}