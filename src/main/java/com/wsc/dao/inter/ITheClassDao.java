package com.wsc.dao.inter;

import com.wsc.pojo.TheClass;

import java.util.List;

/**
 * Created by wsc on 17-1-13.
 */
public interface ITheClassDao {
    /**
     * 创建一个class
     * @param theClass class的内容
     * @return 是否创建成功
     */
    boolean createTheClass(TheClass theClass);

    /**
     * 删除1个class，将标志位由1改为0
     * @param theClassId id
     * @return 删除的情况
     */
    TheClass deleteTheClass(int theClassId);

    /**
     * 通过id更新class信息
     * @param theClassId id
     * @param theClass 新的class的信息
     * @return 更新前的情况
     */
    TheClass updateTheClass(int theClassId,TheClass theClass);

    /**
     * 通过id返回class信息
     * @param theClassId id
     * @return class信息
     */
    TheClass queryTheClass(int theClassId);

    /**
     * 返回class列表
     * @param fromTheClassId 开始的id
     * @param manyTheClassId 数量
     * @return 返回列表
     */
    List<TheClass> queryTheClassList(int fromTheClassId,int manyTheClassId);
}
