package com.wsc.dao.inter;

import com.wsc.pojo.Student;

/**
 * Created by wsc on 17-1-13.
 */
public interface IStudentDao {
    /**
     * 往数据库添加一个学生
     * @param student 学生元素
     * @return true表示添加成功，false表示添加失败
     */
    boolean addStudent(Student student);

    /**
     * 通过studentId删除一个学生
     * @param studentId 学生Id
     * @return 删除学生的信息，这里的删除只是将学生的State由1改为0，在数据库中不会将其完全删除
     */
    Student deleteStudent(int studentId);

    /**
     * 更新学生信息
     * @param student 更新的学生的信息
     * @param studentId 更新信息学生的id
     * @return 是否更新成功
     */
    boolean updateStudent(Student student,int studentId);

    /**
     * 通过学生id查询学生信息
     * @param studentId
     * @return 学生信息
     */
    Student queryStudent(int studentId);
}
