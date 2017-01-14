package com.wsc.dao.inter;

import com.wsc.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wsc on 17-1-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-mybatis.xml"})
public class IStudentDaoTestSpring {
    private static final Logger LOGGER= LoggerFactory.getLogger(IStudentDaoTestSpring.class);

    @Resource
    private IStudentDao iStudentDao;

    @Test
    public void queryStudent() throws Exception {
        Student student=iStudentDao.queryStudent(1);
        LOGGER.info(student.toString());
    }

}