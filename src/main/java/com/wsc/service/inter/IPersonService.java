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
     * 权限管理
     */
    boolean createPerson(int powerId);
    boolean deletePerson(int powerId);
    boolean updatePerson(int powerId);
    boolean queryPerson(int powerId);

    boolean createTestDB(int powerId);
    boolean deleteTestDB(int powerId);
    boolean updateTestDB(int powerId);
    boolean queryTestDB(int powerId);

    boolean createResult(int powerId);
    boolean deleteResult(int powerId);
    boolean updateResult(int powerId);
    boolean queryResult(int powerId);
}
