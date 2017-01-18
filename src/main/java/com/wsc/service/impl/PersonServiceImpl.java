package com.wsc.service.impl;

import com.wsc.dao.inter.IManagerDao;
import com.wsc.dao.inter.IStudentDao;
import com.wsc.dao.inter.ITeacherDao;
import com.wsc.dao.inter.ITheClassDao;
import com.wsc.exceptions.PersonException;
import com.wsc.exceptions.PersonNotExistException;
import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private ITeacherDao iTeacherDao;

    @Autowired
    private IStudentDao iStudentDao;

    @Autowired
    private IManagerDao iManagerDao;

    @Autowired
    private ITheClassDao iTheClassDao;

    private List<Integer> listTeacherId;

    /**
     * 教师及管理员的人员管理
     *
     * @param teacher
     */
    @Override
    public boolean createTeacher(Teacher teacher) throws PersonException{
        listTeacherId=getAllTeacherId();
        if(listTeacherId==null||!listTeacherId.contains(teacher.getTeacherId())){
            iTeacherDao.addTeacher(teacher);
//            LOGGER.info("创建教师数据成功"+teacher.toString());
            return true;
        }
        else{
//            LOGGER.info("创建用户失败,数据库中已经有该数据");
            throw new PersonException("数据库中已经有该数据");
        }
    }

    @Override
    public Teacher updateTeacher(int teacherId, Teacher teacher) {
        Teacher teacherRet=null;
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            teacherRet=queryTeacherByTeacherId(teacherId);
            teacher.setTeacherId(teacher.getTeacherId());
            iTeacherDao.updateTeacher(teacher);
//            LOGGER.info(teacherRet.toString());
            return teacherRet;
        }
        else{
//            LOGGER.info("不能更新数据,由于数据库中没有该数据");
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public Teacher deleteTeacher(int teacherId) {
        return null;
    }

    @Override
    public List<Teacher> queryTeacherAll() {
        return null;
    }

    @Override
    public List<Teacher> queryTeacherByPaperId(int paperId) {
        return null;
    }

    @Override
    public List<Teacher> queryTeacherByClassId(int classId) {
        return null;
    }

    @Override
    public List<Teacher> queryTeacherByTeacherName(String name) {
        return null;
    }

    @Override
    public Teacher queryTeacherByTeacherId(int teacherId) {
        return null;
    }

    /**
     * 学生的人员管理
     *
     * @param student
     */
    @Override
    public boolean createStudent(Student student) {
        return false;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(int studentId) {
        return null;
    }

    @Override
    public List<Student> queryStudentAll() {
        return null;
    }

    @Override
    public List<Student> queryStudentByPaperId(int studentId) {
        return null;
    }

    @Override
    public List<Student> queryStudentByClassId(int classId) {
        return null;
    }

    @Override
    public List<Student> queryStudentByStudentName(String name) {
        return null;
    }

    @Override
    public Student queryStudentByStudentId(String studentId) {
        return null;
    }

    /**
     * 教师及管理员的权限管理
     *
     * @param teacherId
     */
    @Override
    public boolean createPerson(int teacherId) {
        return false;
    }

    @Override
    public boolean deletePerson(int teacherId) {
        return false;
    }

    @Override
    public boolean updatePerson(int teacherId) {
        return false;
    }

    @Override
    public boolean queryPerson(int teacherId) {
        return false;
    }

    @Override
    public boolean createTestDB(int teacherId) {
        return false;
    }

    @Override
    public boolean deleteTestDB(int teacherId) {
        return false;
    }

    @Override
    public boolean updateTestDB(int teacherId) {
        return false;
    }

    @Override
    public boolean queryTestDB(int teacherId) {
        return false;
    }

    @Override
    public boolean createResult(int teacherId) {
        return false;
    }

    @Override
    public boolean deleteResult(int teacherId) {
        return false;
    }

    @Override
    public boolean updateResult(int teacherId) {
        return false;
    }

    @Override
    public boolean queryResult(int teacherId) {
        return false;
    }

    private List<Integer> getAllTeacherId(){
        return iTeacherDao.queryTeacherIdAll();
    }
}
