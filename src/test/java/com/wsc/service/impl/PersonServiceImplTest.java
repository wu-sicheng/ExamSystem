package com.wsc.service.impl;

import com.wsc.dao.inter.IStudentDao;
import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class PersonServiceImplTest {
    private static final Logger LOGGER= LoggerFactory.getLogger(PersonServiceImplTest.class);

    @Resource
    private IPersonService iPersonService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createTeacher() throws Exception {
        Teacher teacher=new Teacher(12,"123","11,21","thisis","password",1,"123","mail@mail.com","123132131",1,1,new Date(),new Date());
        iPersonService.createTeacher(teacher);
    }

    @Test
    public void updateTeacher() throws Exception {
        Teacher teacher=new Teacher(3,"new for4,2","23,34,","wusicheng","password",1,"123","mail@mail.com","123132131",1,1,new Date(),new Date());
        iPersonService.updateTeacher(3,teacher);
    }

    @Test
    public void deleteTeacher() throws Exception {
        iPersonService.deleteTeacher(3);
    }

    @Test
    public void queryTeacherAll() throws Exception {
        LOGGER.info(iPersonService.queryTeacherAll().toString());
    }

    @Test
    public void queryTeacherByPaperId() throws Exception {
        LOGGER.info(iPersonService.queryTeacherByPaperId(13).toString());
    }

    @Test
    public void queryTeacherByClassId() throws Exception {
        LOGGER.info(iPersonService.queryTeacherByClassId(189).toString());
    }

    @Test
    public void queryTeacherByTeacherName() throws Exception {
        List<Teacher> teachers=iPersonService.queryTeacherByTeacherName("thisis");
        LOGGER.info(teachers.toString());
    }

    @Test
    public void queryTeacherByTeacherId() throws Exception {
        Teacher teacher=iPersonService.queryTeacherByTeacherId(3);
        LOGGER.info(teacher.toString());
    }

    @Test
    public void createStudent() throws Exception {
        Student student=new Student(8,8,"1,2","testforName","test",1,"sstes","major",1,"12323","134@qq.com","12313",1,1,new Date(),new Date());
        iPersonService.createStudent(student);
    }

    @Test
    public void updateStudent() throws Exception {
        Student student=new Student(7,8,"changefor1","test","test",1,"sstes","major",1,"12323","134@qq.com","12313",1,1,new Date(),new Date());
        iPersonService.updateStudent(1,student);
    }

    @Test
    public void deleteStudent() throws Exception {
        iPersonService.deleteStudent(1);
    }

    @Test
    public void queryStudentAll() throws Exception {
        List<Student> students=iPersonService.queryStudentAll();
        LOGGER.info(students.toString());
    }

    @Test
    public void queryStudentByPaperId() throws Exception {
        List<Student> students=iPersonService.queryStudentByPaperId(1);
        LOGGER.info(students.toString());
    }

    @Test
    public void queryStudentByClassId() throws Exception {
        List<Student> students=iPersonService.queryStudentByClassId(8);
        LOGGER.info(students.toString());
    }

    @Test
    public void queryStudentByStudentName() throws Exception {
        List<Student> students=iPersonService.queryStudentByStudentName("testforName");
        LOGGER.info(students.toString());
    }

    @Test
    public void queryStudentByStudentId() throws Exception {
        Student student=iPersonService.queryStudentByStudentId(2);
        LOGGER.info(student.toString());
    }

    @Test
    public void createPerson() throws Exception {
        boolean b=iPersonService.createPerson(5);
        LOGGER.info(String.valueOf(b));
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