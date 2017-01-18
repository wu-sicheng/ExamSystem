package com.wsc.dao.inter;

import com.wsc.pojo.Manager;
import java.util.List;

/**
 * Created by wsc on 17-1-13.
 * 权限控制，分level1,level2,level3　３个等级
 * 管理的权限为创建各类的pojo，删除各类的pojo，更新各类的pojo，查询各类的pojo
 * level1：学生，创建，查询，更新student，查询paper，创建，查询class，创建result
 * level2：教师，创建，查询，更新teacher，创建，查询，更新paper，question，创建，查询class，查询更新result
 * level3：管理员，能够执行所有的数据库操作，以及提升，降低各用户权限。删除的只是标志位的删除
 */
public interface IManagerDao {
    /**
     * 创建一个新的用户权限
     * @param manager 权限设置
     * @return 权限的等级代号(id)
     */
    int createPower(Manager manager);

    /**
     * 删除用户权限，这里只是将managerState由1改为0，不能删除权限1~3
     * @param id 删除权限的id值
     * @return 删除的id值
     */
    int deletePower(int id);

    /**
     * 查询所有的Manager
     * @return Manager列表
     */
    List<Manager> queryAllManager();

    /**
     * 通过manager判断id
     * @param managerId
     * @return id
     */
    int judgePower(int managerId);

    /**
     * 通过ManagerId查找Manager
     * @param managerId
     * @return 查找的Manager
     */
    Manager queryManagerByManagerId(int managerId);

    /**
     * 返回manager的id值
     * @return id列表
     */
    List<Integer> queryIdList();

    /**
     * 返回managerId的列表
     * @return managerId
     */
    List<Integer> queryManagerIdList();
}
