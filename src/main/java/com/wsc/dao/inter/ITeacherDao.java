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
    void deleteTeacher(int teacherId);

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
    List<Teacher> queryTeacherList(@Param("fromTeacherId") int fromTeacherId,@Param("toTeacherId") int toTeacherId);

    /**
     * 通过班级查询老师
     * @param classId 班级id
     * @return
     */
    List<Teacher> queryTeacherByClassId(String classId);

    List<Teacher> queryTeacherByPaperId(String paperId);

    Teacher queryTeacherByTeacherName(String teacherName);

    List<Integer> queryTeacherIdAll();

    int queryTeacherPower(int teacherId);

    /**
     * 提升某个用户的权限，一次只能够提升一个等级
     * @param id 用户的id
     * @return 用户提升后的权限
     */
    int upperPower(int id);

    /**
     * 降低用户权限，一次只能降低一个等级
     * @param id 用户的id
     * @return 用户降低后的权限
     */
    int lowerPower(int id);

    /**
     * 讲用户权限设为3
     * @param id 用户id
     * @return 设置后的等级
     */
    int setLevel3(int id);

    /**
     * 讲用户权限设为2
     * @param id 用户id
     * @return 设置后的等级
     */
    int setLevel2(int id);

    /**
     * 讲用户权限设为1
     * @param id 用户id
     * @return 设置后的等级
     */
    int setLevel1(int id);

    Set<String> findRoles(String teacherName);

    Set<String> findPermissions(String teacherName);
}
