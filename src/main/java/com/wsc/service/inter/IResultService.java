package com.wsc.service.inter;

import com.wsc.pojo.Result;

import java.util.List;

/**
 * Created by wsc on 17-1-16.
 */
public interface IResultService {
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
    List<Result> queryResultList(int fromResultId, int manyResultId);

    /**
     * 通过studentId查询其各科考试结果
     * @param studentId studentId
     * @return 结果集
     */
    List<Result> queryResultByStudentId(int studentId);

    /**
     * 通过paperId和studentId查询其某科的考试结果
     * @param paperId 试卷id
     * @param studentId 学生id
     * @return 结果
     */
    Result queryResultByPaperIdStudentId(int paperId,int studentId);

    /**
     * 判断某个题目是否删除
     * @param resultId 结果id
     * @return 是否删除
     */
    boolean isDelete(int resultId);

}
