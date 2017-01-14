package com.wsc.dao.inter;

import com.wsc.pojo.Teacher;

import java.util.List;

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
    List<Teacher> queryTeacherList(int fromTeacherId,int manyTeacherId);
}
