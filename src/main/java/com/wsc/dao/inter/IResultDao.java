package com.wsc.dao.inter;

import com.wsc.pojo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wsc on 17-1-13.
 */
public interface IResultDao {

    /**
     * ???????????state??1???????
     * @param result ??
     * @return ??????
     */
    void createResult(Result result);

    /**
     * ??id????????state??0???????
     * @param resultId ???id
     * @return ?????
     */
    void deleteResult(int resultId);

    /**
     * ??resultId????
     * @param result
     * @return ??????
     */
    void updateResult(Result result);

    /**
     * ??id???????
     * @param resultId id
     * @return ??????
     */
    Result queryResult(int resultId);

    /**
     * ?????
     * @param fromResultId ???id
     * @param toResultId ???id
     * @return ???id
     */
    List<Result> queryResultList(@Param("fromResultId")int fromResultId,@Param("toResultId")int toResultId);

    List<Integer> queryResultIdList();

    List<Result> queryResultListByStudentId(int studentId);

    List<Result> queryResultListByPaperId(int paperId);
}
