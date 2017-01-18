package com.wsc.service.impl;

import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by wsc on 17-1-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class PersonServiceImplTest {

    @Resource
    private IPersonService iPersonService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createTeacher() throws Exception {
        Teacher teacher=new Teacher(5,"1,2","1,2","wusicheng","password",1,"123","mail@mail.com","123132131",1,1,new Date(),new Date());
        iPersonService.createTeacher(teacher);
    }

    @Test
    public void updateTeacher() throws Exception {
        Teacher teacher=new Teacher(4,"1fgageafea,2","1,2","wusicheng","password",1,"123","mail@mail.com","123132131",1,1,new Date(),new Date());
        iPersonService.updateTeacher(4,teacher);
    }

    @Test
    public void deleteTeacher() throws Exception {

    }

    @Test
    public void queryTeacherAll() throws Exception {

    }

    @Test
    public void queryTeacherByPaperId() throws Exception {

    }

    @Test
    public void queryTeacherByClassId() throws Exception {

    }

    @Test
    public void queryTeacherByTeacherName() throws Exception {

    }

    @Test
    public void queryTeacherByTeacherId() throws Exception {

    }

    @Test
    public void createStudent() throws Exception {

    }

    @Test
    public void updateStudent() throws Exception {

    }

    @Test
    public void deleteStudent() throws Exception {

    }

    @Test
    public void queryStudentAll() throws Exception {

    }

    @Test
    public void queryStudentByPaperId() throws Exception {

    }

    @Test
    public void queryStudentByClassId() throws Exception {

    }

    @Test
    public void queryStudentByStudentName() throws Exception {

    }

    @Test
    public void queryStudentByStudentId() throws Exception {

    }

    @Test
    public void createPerson() throws Exception {

    }

    @Test
    public void deletePerson() throws Exception {

    }

    @Test
    public void updatePerson() throws Exception {

    }

    @Test
    public void queryPerson() throws Exception {

    }

    @Test
    public void createTestDB() throws Exception {

    }

    @Test
    public void deleteTestDB() throws Exception {

    }

    @Test
    public void updateTestDB() throws Exception {

    }

    @Test
    public void queryTestDB() throws Exception {

    }

    @Test
    public void createResult() throws Exception {

    }

    @Test
    public void deleteResult() throws Exception {

    }

    @Test
    public void updateResult() throws Exception {

    }

    @Test
    public void queryResult() throws Exception {

    }

}