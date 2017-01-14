package com.wsc.dao.inter;

import com.wsc.pojo.Manager;

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
}
