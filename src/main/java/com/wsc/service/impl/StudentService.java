package com.wsc.service.impl;

import com.wsc.dao.inter.IStudentDao;
import com.wsc.pojo.Student;
import com.wsc.service.inter.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wsc on 17-1-17.
 */
@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDao iStudentDao;

    @Override
    public boolean addStudent(Student student) {
        iStudentDao.addStudent(student);
        return true;
    }

    @Override
    public Student deleteStudent(int studentId) {
        Student student=queryStudent(studentId);
        iStudentDao.deleteStudent(studentId);
        return student;
    }

    @Override
    public boolean updateStudent(Student student, int studentId) {
        iStudentDao.updateStudent(student,studentId);
        return true;
    }

    @Override
    public Student queryStudent(int studentId) {
        Student student=iStudentDao.queryStudent(studentId);
        return student;
    }

    @Override
    public List<Student> queryStudentList(int fromStudentId, int manyStudentId) {
        return iStudentDao.queryStudentList(fromStudentId,manyStudentId);
    }

    @Override
    public List<Student> queryStudentByTheClassId(int classId) {
        return iStudentDao.queryStudentByTheClassId(classId);
    }

    @Override
    public Student queryStudentByStudentNum(String studentNum) {
        return iStudentDao.queryStudentByStudentNum(studentNum);
    }

    @Override
    public boolean isDelete(int studentId) {
        Student student=queryStudent(studentId);
        return student.getStudentState()==1;
    }

    @Override
    public List<Student> queryStudentByPaperId(int paperId) {
        String paperIdStr=String.valueOf(paperId);
        return iStudentDao.queryStudentByPaperId(paperIdStr);
    }
}
