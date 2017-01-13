package com.wsc.dao.inter;

import com.wsc.pojo.TheClass;

/**
 * Created by wsc on 17-1-13.
 */
public interface ITheClassDao {
    boolean createTheClass(TheClass theClass);
    TheClass deleteTheClass(int theClassId);
    TheClass updateTheClass(int theClassId,TheClass theClass);
    TheClass queryTheClass(int theClassId);
}
