package com.wsc.dao.inter;

import com.wsc.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.*;

/**
 * Created by wsc on 17-1-14.
 */
public class IStudentDaoTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private static final Logger LOGGER= LoggerFactory.getLogger(IStudentDaoTest.class);
    @Before
    public void setUp() throws Exception {
        try{
            reader= Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            LOGGER.error("Error,can't find the resources");
        } catch (IOException e) {
            LOGGER.error("Error,can't find the resources");
            e.printStackTrace();
        }
    }

    @Test
    public void queryStudent() throws Exception {
        SqlSession session=sqlSessionFactory.openSession();
        try{
            Student student=(Student)session.selectOne("com.wsc.dao.inter.IStudentDao.queryStudent",1);
            LOGGER.info(student.toString());
        }finally {
            session.close();
        }
    }

    @Test
    public void addStudent() throws Exception{
        Student student=new Student(2,2,"1,2","wu","123",1,"123","te",1,"12","sad","70000",2,1);
        SqlSession session=sqlSessionFactory.openSession();
        try{
            IStudentDao iStudentDao=session.getMapper(IStudentDao.class);
            iStudentDao.addStudent(student);
            session.commit();
            Student student2=(Student)session.selectOne("com.wsc.dao.inter.IStudentDao.queryStudent",1);
            LOGGER.info(student2.toString());
        }finally {
            session.close();
        }
    }
}
