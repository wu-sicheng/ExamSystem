package com.wsc.dao.inter;

import com.wsc.pojo.Teacher;

/**
 * Created by wsc on 17-1-13.
 */
public interface ITeacherDao {
    boolean addTeacher(Teacher teacher);
    Teacher deleteTeacher(int teacherId);
    Teacher updateTeacher(int teacherId,Teacher teacher);
    Teacher queryTeacher(int teacherId);
}
