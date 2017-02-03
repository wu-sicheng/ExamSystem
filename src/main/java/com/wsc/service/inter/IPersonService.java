package com.wsc.service.inter;

import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.pojo.TheClass;

import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-18.
 */
public interface IPersonService {
    /*
     * 教师及管理员的人员管理
     */
    boolean createTeacher(Teacher teacher);
    Teacher updateTeacher(int teacherId,Teacher teacher);
    Teacher deleteTeacher(int teacherId);
    List<Teacher> queryTeacherAll();
    List<Teacher> queryTeacherByPaperId(int paperId);
    List<Teacher> queryTeacherByClassId(int classId);
    Teacher queryTeacherByTeacherName(String name);
    Teacher queryTeacherByTeacherId(int teacherId);


    /*
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

    /*
    班级管理
     */
    boolean createTheClass(TheClass theClass);
    TheClass deleteTheClass(int theClassId);
    TheClass updateTheClass(TheClass theClass);
    TheClass queryTheClass(int theClassId);
    List<TheClass> queryTheClassList(int fromTheClassId,int toTheClassId);
    List<TheClass> queryTheClassListAll();

    /*
     * 权限管理1
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

    /*
    权限管理2
     */
    Set<String> findRoles(String name);
    Set<String> findPermissions(String name);
}
