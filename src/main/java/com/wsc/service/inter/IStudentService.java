package com.wsc.service.inter;

import com.wsc.pojo.Student;

import java.util.List;

/**
 * Created by wsc on 17-1-16.
 */
public interface IStudentService {
    /**
     * 往数据库添加一个学生
     * @param student 学生元素
     * @return true表示添加成功，false表示添加失败
     */
    boolean addStudent(Student student);

    /**
     * 通过studentId删除一个学生
     * @param studentId 学生Id
     * @return 删除学生的信息，这里的删除只是将学生的State由1改为0，在数据库中不会将其完全删
     Student deleteStudent(int studentId);
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

    /**
     * 查询一个学生集
     * @param fromStudentId 开始的id
     * @param manyStudentId 结束的id
     * @return 结果集
     */
    List<Student> queryStudentList(int fromStudentId, int manyStudentId);

    /**
     * 通过class查询同一个班的学生
     * @param theClassId classid
     * @return 同一个班学生的结果集
     */
    List<Student> queryStudentByTheClassId(int theClassId);

    /**
     * 通过准考证号查询学生的信息
     * @param studentNum 准考证号
     * @return 学生
     */
    Student queryStudentByStudentNum(String studentNum);

    /**
     * 判断学生是否删除
     * @param studentId 学生的id
     * @return 判断是否删除
     */
    boolean isDelete(int studentId);

    /**
     * 通过paperId查看学生
     * @param paperId id
     * @return 学生
     */
    List<Student> queryStudentByPaperId(int paperId);
}
