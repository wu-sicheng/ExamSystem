package com.wsc.dao.inter;

import com.wsc.pojo.Manager;
import com.wsc.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 用于spring和mybatis的整合测试
 * Created by wsc on 17-1-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)//Spring结合JUnit
@ContextConfiguration(value = {"classpath:spring-mybatis.xml"})//运行Junit的时候将设置文件载入
public class IStudentDaoTest {
    private static final Logger LOGGER= LoggerFactory.getLogger(IStudentDaoTest.class);

    @Resource
    private IStudentDao iStudentDao;

    @Resource
    private IManagerDao iManagerDao;

    @Test
    public void queryStudent() throws Exception {
        Student student=iStudentDao.queryStudent(1);
        LOGGER.info(student.toString());
    }

    @Test
    public void addManager() throws Exception{
        Manager manager=new Manager(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        iManagerDao.createPower(manager);
    }
}