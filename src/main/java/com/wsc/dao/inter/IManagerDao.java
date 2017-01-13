package com.wsc.dao.inter;

/**
 * Created by wsc on 17-1-13.
 */
public interface IManagerDao {
    int upperPower(int id);
    int lowerPower(int id);

    int setLevel3(int id);
    int setLevel2(int id);
    int setLevel1(int id);
}
