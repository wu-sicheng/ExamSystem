package com.wsc.service.inter;

import com.wsc.pojo.Manager;

/**
 * 权限管理接口
 * Created by wsc on 17-1-15.
 */
public interface IManagerService {
    /**
     * 创建新的权限
     * @param manager 权限
     * @return 权限代码
     */
    int createPower(Manager manager);

    /**
     * 删除权限
     * @param managerId 权限的id
     * @return 权限的id
     */
    int deletePower(int managerId);

    /**
     * 判断教师和学生的权限
     * @param id 教师的id
     * @return 返回权限值
     */
    int judgePower(int id);

    boolean judgeCreateStudent(int id);
    boolean judgeCreateTeacher(int id);
    boolean judgeCreatePaper(int id);
    boolean judgeCreateQuestion(int id);
    boolean judgeCreateResult(int id);
    boolean judgeCreateTheClass(int id);

    boolean judgeDeleteStudent(int id);
    boolean judgeDeleteTeacher(int id);
    boolean judgeDeletePaper(int id);
    boolean judgeDeleteQuestion(int id);
    boolean judgeDeleteResult(int id);
    boolean judgeDeleteTheClass(int id);

    boolean judgeUpdateStudent(int id);
    boolean judgeUpdateTeacher(int id);
    boolean judgeUpdatePaper(int id);
    boolean judgeUpdateQuestion(int id);
    boolean judgeUpdateResult(int id);
    boolean judgeUpdateTheClass(int id);

    boolean judgeQueryStudent(int id);
    boolean judgeQueryTeacher(int id);
    boolean judgeQueryPaper(int id);
    boolean judgeQueryQuestion(int id);
    boolean judgeQueryResult(int id);
    boolean judgeQueryTheClass(int id);

    boolean judgeManageState(int id);


}
