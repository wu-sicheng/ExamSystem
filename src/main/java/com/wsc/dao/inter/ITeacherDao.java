package com.wsc.dao.inter;

import com.wsc.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-13.
 */
public interface ITeacherDao {
    /**
     * 创建一个教师
     * @param teacher 教师的相关资料
     * @return 是否创建成功
     */
    boolean addTeacher(Teacher teacher);

    /**
     * 通过id删除一个教师，将state由1变成0，添加删除时间
     * @param teacherId id
     * @return 删除老师的详情
     */
    void deleteTeacherByTeacherId(int teacherId);

    /**
     * 通过id更新学生信息
     * @param teacher 教师的详情
     * @return 更新前教师的信息
     */
    void updateTeacher(Teacher teacher);

    /**
     * 通过id查询一个教师的情况
     * @param teacherId id
     * @return 教师的情况
     */
    Teacher queryTeacherById(int teacherId);

    /**
     * 查询教师结果集
     * @param fromTeacherId 开始的id
     * @param toTeacherId 到什么的地方为止
     * @return 教师结果集
     */
    Set<Teacher> queryTeacherList(@Param("fromTeacherId") int fromTeacherId,@Param("toTeacherId") int toTeacherId);

    /**
     * 通过班级查询老师
     * @param classId 班级id
     * @return
     */
    Set<Teacher> queryTeacherByClassId(String classId);

    Set<Teacher> queryTeacherByPaperId(String paperId);

    Teacher queryTeacherByTeacherName(String teacherName);

    Set<Integer> queryTeacherIdAll();

    Set<String> findRoles(String teacherMail);

    Set<String> findPermissions(String teacherMail);

    Teacher queryTeacherByMail(String mail);
    Teacher queryTeacherByName(String name);
    Teacher queryTeacherByPhone(String phone);

    int queryTeacherIdByPhone(String phone);
    int queryTeacherIdByMail(String mail);
    int queryTeacherIdByName(String name);

    Set<Integer> queryListTeacherId();
    Set<String> queryListTeacherName();
    Set<String> queryListTeacherMail();
    Set<String> queryListTeacherPhone();
}
