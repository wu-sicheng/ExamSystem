package com.wsc.dao.inter;

import com.wsc.pojo.Student;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

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
     * @return 删除学生的信息，这里的删除只是将学生的State由1改为0，在数据库中不会将其完全删
    Student deleteStudent(int studentId);
     */

    void deleteStudent(int studentId);
    /**
     * 更新学生信息
     * @param student 更新的学生的信息
     * @return 是否更新成功
     */
    void updateStudent(Student student);

    /**
     * 通过学生id查询学生信息
     * @param studentId
     * @return 学生信息
     */
    Student queryStudent(int studentId);

    /**
     * 查询一个学生集
     * @param fromStudentId 开始的id
     * @param toStudentId 结束的id
     * @return 结果集
     */
    Set<Student> queryStudentList(@Param("fromStudentId") int fromStudentId,@Param("toStudentId") int toStudentId);

    /**
     * 通过id查找一个班级的学生
     * @param classId classid
     * @return 学生结果集
     */
    Set<Student> queryStudentByTheClassId(int classId);

    /**
     * 通过准考证号查找学生
     * @param studentNum
     * @return 学生
     */
    Student queryStudentByStudentNum(String studentNum);

    /**
     * 通过paperId查询学生
     * @param papaerId paperid
     * @return 学生列表
     */
    Set<Student> queryStudentByPaperId(String papaerId);

    Set<Integer> queryStudentIdAll();

    Student queryStudentByStudentName(String studentName);

    Student queryStudentByStudentMail(String studentMail);

    Set<String> findRoles(String studentMail);

    Set<String> findPermissions(String studentMail);

    Student queryStudentByStudentNo(String studentNo);
    Student queryStudentByStudentPhone(String studentPhone);
    Set<String> querySetStudentMail();
    Set<String> querySetStudentPhone();
    Set<String> querySetStudentName();
}
