package com.wsc.service.inter;

import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;

import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
public interface IPersonService {
    /**
     * 教师及管理员的人员管理
     */
    boolean createTeacher(Teacher teacher);
    Teacher updateTeacher(int teacherId,Teacher teacher);
    Teacher deleteTeacher(int teacherId);
    List<Teacher> queryTeacherAll();
    List<Teacher> queryTeacherByPaperId(int paperId);
    List<Teacher> queryTeacherByClassId(int classId);
    List<Teacher> queryTeacherByTeacherName(String name);
    Teacher queryTeacherByTeacherId(int teacherId);


    /**
     * 学生的人员管理
     */
    boolean createStudent(Student student);
    Student updateStudent(int studentId,Student student);
    Student deleteStudent(int studentId);
    List<Student> queryStudentAll();
    List<Student> queryStudentByPaperId(int studentId);
    List<Student> queryStudentByClassId(int classId);
    List<Student> queryStudentByStudentName(String name);
    Student queryStudentByStudentId(int studentId);


    /**
     * 教师及管理员的权限管理
     */
    boolean createPerson(int teacherId);
    boolean deletePerson(int teacherId);
    boolean updatePerson(int teacherId);
    boolean queryPerson(int teacherId);

    boolean createTestDB(int teacherId);
    boolean deleteTestDB(int teacherId);
    boolean updateTestDB(int teacherId);
    boolean queryTestDB(int teacherId);

    boolean createResult(int teacherId);
    boolean deleteResult(int teacherId);
    boolean updateResult(int teacherId);
    boolean queryResult(int teacherId);
}
