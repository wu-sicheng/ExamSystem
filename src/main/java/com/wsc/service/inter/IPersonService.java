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
    Teacher deleteTeacherByTeacherId(int teacherId);
    Set<Teacher> queryTeacherAll();
    Set<Teacher> queryTeacherByPaperId(int paperId);
    Set<Teacher> queryTeacherByClassId(int classId);
    Teacher queryTeacherByTeacherName(String name);
    Teacher queryTeacherByTeacherId(int teacherId);

    Teacher updateTeacherByMail(Teacher teacher);
    Teacher deleteTeacherByTeacherMail(String teacherMail);

    Set<String> findRoles(String name);
    Set<String> findPermissions(String name);


    Set<Integer> queryListTeacherId();
    Set<String> queryListTeacherName();
    Set<String> queryListTeacherMail();
    Set<String> queryListTeacherPhone();
    Teacher queryTeacherByMail(String mail);
    Teacher queryTeacherByName(String name);
    Teacher queryTeacherByPhone(String phone);
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
}
