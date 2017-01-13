package com.wsc.dao.inter;

import com.wsc.pojo.Result;

/**
 * Created by wsc on 17-1-13.
 */
public interface IResultDao {
    boolean createResult(Result result);
    Result deleteResult(int resultId);
    Result updateResult(int resultId,Result result);
    Result queryResult(int resultId);
}
