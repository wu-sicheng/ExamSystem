package com.wsc.service.inter;

import com.wsc.dto.DBMess;

import java.io.IOException;

/**
 * Created by wsc on 17-1-30.
 */
public interface IInitService {
    void setDBMess(DBMess dbMess) throws IOException;
}
