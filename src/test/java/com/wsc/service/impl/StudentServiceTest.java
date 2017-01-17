package com.wsc.service.impl;

import com.wsc.pojo.Student;
import com.wsc.service.inter.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

/**
 * Created by wsc on 17-1-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class StudentServiceTest {

    @Resource
    private IStudentService iStudentService;

    @Test
    public void addStudent() throws Exception {
        Student student=new Student(4,2,"1,2,3","wusicheng2","password",1,"1234","major",1,"no1234","asd@qw.com","1fafaw",1,1,new Date(),new Date());
        iStudentService.addStudent(student);
    }

    @Test
    public void deleteStudent() throws Exception {

    }

    @Test
    public void updateStudent() throws Exception {

    }

    @Test
    public void queryStudent() throws Exception {

    }

    @Test
    public void queryStudentList() throws Exception {

    }

    @Test
    public void queryStudentByTheClassId() throws Exception {

    }

    @Test
    public void queryStudentByStudentNum() throws Exception {

    }

    @Test
    public void isDelete() throws Exception {

    }

    @Test
    public void queryStudentByPaperId() throws Exception {

    }

}