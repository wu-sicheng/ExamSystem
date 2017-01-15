package com.wsc.dao.inter;

import com.wsc.pojo.Result;
import java.util.List;

/**
 * Created by wsc on 17-1-13.
 */
public interface IResultDao {

    /**
     * 创建一个学生考试结果，state置为1，添加创建时间
     * @param result 结果
     * @return 是否创建成功
     */
    boolean createResult(Result result);

    /**
     * 通过id删除一个结果，将state置为0，添加删除时间
     * @param resultId 删除的id
     * @return 删除的结果
     */
    Result deleteResult(int resultId);

    /**
     * 通过resultId更新结果
     * @param resultId
     * @param result
     * @return 更新前的结果
     */
    Result updateResult(int resultId,Result result);

    /**
     * 通过id来查询一个结果
     * @param resultId id
     * @return 查询到的结果
     */
    Result queryResult(int resultId);

    /**
     * 查询结果集
     * @param fromResultId 开始的id
     * @param manyResultId 结束的id
     * @return 查询的id
     */
    List<Result> queryResultList(int fromResultId,int manyResultId);
}
