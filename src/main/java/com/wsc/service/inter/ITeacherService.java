package com.wsc.service.inter;

import com.wsc.pojo.Teacher;

import java.util.List;

/**
 * Created by wsc on 17-1-16.
 */
public interface ITeacherService {
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
    Teacher deleteTeacher(int teacherId);

    /**
     * 通过id更新学生信息
     * @param teacherId 教师的id
     * @param teacher 教师的详情
     * @return 更新前教师的信息
     */
    Teacher updateTeacher(int teacherId,Teacher teacher);

    /**
     * 通过id查询一个教师的情况
     * @param teacherId id
     * @return 教师的情况
     */
    Teacher queryTeacher(int teacherId);

    /**
     * 查询教师结果集
     * @param fromTeacherId 开始的id
     * @param manyTeacherId 数量
     * @return 教师结果集
     */
    List<Teacher> queryTeacherList(int fromTeacherId, int manyTeacherId);

    /**
     * 通过班级查询老师
     * @param classId 班级id
     * @return
     */
    List<Teacher> queryTeacherByClassId(String classId);

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

    List<Teacher> queryTeacherByTheClassId(int theClassId);
    List<Teacher> queryTeacherByPaperId(int paperId);
    List<Teacher> queryTeacherByTeacherName(String teacherName);
    boolean isDelete(int teacherId);

}
