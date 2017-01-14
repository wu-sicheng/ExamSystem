package com.wsc.dao.impl;

import com.wsc.dao.inter.IStudentDao;
import com.wsc.pojo.Student;

/**
 * Created by wsc on 17-1-13.
 */
public class StudentDaoImpl implements IStudentDao {
    @Override
    public boolean addStudent(Student student) {
        return false;
    }

/*    @Override
    public Student deleteStudent(int studentId) {
        return null;
    }*/

    @Override
    public boolean updateStudent(Student student, int studentId) {
        return false;
    }

    @Override
    public Student queryStudent(int studentId) {
        return null;
    }
}
