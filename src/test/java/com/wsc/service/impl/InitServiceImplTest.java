package com.wsc.service.impl;

import com.wsc.dto.DBMess;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wsc on 17-1-30.
 */
public class InitServiceImplTest {
    @Test
    public void setDBMess() throws Exception {
        InitServiceImpl initService=new InitServiceImpl();
        initService.setDBMess(new DBMess());
    }

}