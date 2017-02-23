package com.wsc.service.impl;

import com.mysql.cj.api.mysqla.result.ResultsetRow;
import com.sun.org.apache.regexp.internal.RE;
import com.wsc.dao.inter.IResultDao;
import com.wsc.exceptions.ManagerException;
import com.wsc.exceptions.ResultException;
import com.wsc.pojo.Result;
import com.wsc.pojo.Student;
import com.wsc.service.inter.IPersonService;
import com.wsc.service.inter.IResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-25.
 */
@Service
public class ResultServiceImpl implements IResultService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ResultServiceImpl.class);
    private List<Integer> resultIdList;

    @Autowired
    private IPersonService iPersonService;

    @Autowired
    private IResultDao iResultDao;

    /**
     * 创建一个学生考试结果，state置为1，添加创建时间
     * @param result  结果
     * @return 是否创建成功
     */
    @Override
    public boolean createResult(Result result) {
        resultIdList=getResultIdList();
        if(!resultIdList.contains(result.getResultId())){
            iResultDao.createResult(result);
            return true;
        }
        else{
            LOGGER.info("数据库result包含数据result_id为"+result.getResultId()+"的数据");
            throw new ResultException("数据库result包含数据result_id为"+result.getResultId()+"的数据");
        }
    }

    /**
     * 通过id删除一个结果，将state置为0，添加删除时间
     * @param resultId 删除的id
     * @return 删除的结果
     */
    @Override
    public Result deleteResult(int resultId) {
        resultIdList=getResultIdList();
        if(resultIdList.contains(resultId)){
            Result resultRe=iResultDao.queryResult(resultId);
            iResultDao.deleteResult(resultId);
            return resultRe;
        }
        else {
            LOGGER.info("数据库result不包含数据result_id为" + resultId + "的数据");
            throw new ResultException("数据库result不包含数据result_id为" + resultId + "的数据");
        }
    }

    /**
     * 通过resultId更新结果
     * @param result
     * @return 更新前的结果
     */
    @Override
    public Result updateResult(Result result) {
        resultIdList=getResultIdList();
        if(resultIdList.contains(result.getResultId())){
            Result resultRe=iResultDao.queryResult(result.getResultId());
            iResultDao.updateResult(result);
            return resultRe;
        }
        else{
            LOGGER.info("数据库result不包含数据result_id为"+result.getResultId()+"的数据");
            throw new ResultException("数据库result不包含数据result_id为"+result.getResultId()+"的数据");
        }
    }

    /**
     * 通过id来查询一个结果
     *
     * @param resultId id
     * @return 查询到的结果
     */
    @Override
    public Result queryResult(int resultId) {
        resultIdList=getResultIdList();
        if(resultIdList.contains(resultId)){
            return iResultDao.queryResult(resultId);
        }
        else{
            LOGGER.info("数据库result中不存在result_id为"+resultId+"的数据");
            throw new ResultException("数据库result中不存在result_id为"+resultId+"的数据");
        }
    }

    /**
     * 查询结果集
     * @param fromResultId 开始的id
     * @param toResultId   结束的id
     * @return 查询的id
     */
    @Override
    public List<Result> queryResultList(int fromResultId, int toResultId) {
        List<Result> results = iResultDao.queryResultList(fromResultId, toResultId);
        try {
            if (results.get(0) != null) {
                return iResultDao.queryResultList(fromResultId, toResultId);
            }
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info(e.getMessage());
            LOGGER.info("数据库result找不到符合from_result_id:" + fromResultId + "到to_result_id:" + toResultId + "的数据");
            throw new ResultException("数据库result找不到符合from_result_id:" + fromResultId + "到to_result_id:" + toResultId + "的数据");
        }
        return null;
    }

    @Override //TODO
    public List<Result> queryResultListByStudentId ( int studentId){
        List<Result> resultRe = iResultDao.queryResultListByStudentId(studentId);
        try {
            if (resultRe.get(0) != null) {
                return resultRe;
            }
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info(e.getMessage());
            LOGGER.info("数据库result没有符合student_id为" + studentId + "的数据");
            throw new ResultException("数据库result没有符合student_id为" + studentId + "的数据");
        }
        return null;
    }

    @Override
    public List<Result> queryResultListByPaperId ( int paperId){
        List<Result> resultRe = iResultDao.queryResultListByPaperId(paperId);
        try {
            if (resultRe.get(0) != null) {
                return resultRe;
            }
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info(e.getMessage());
            LOGGER.info("数据库result没有符合paper_id为" + paperId + "的数据");
            throw new ResultException("数据库result没有符合paperId_id为" + paperId + "的数据");
        }
        return null;
    }

    @Override
    public List<Result> queryResultListByTheClassId ( int theClassId){
        Set<Student> studentList = iPersonService.queryStudentByClassId(theClassId);
        List<Result> studentResultByClassId = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
           /* studentResultByClassId.addAll(iResultDao.queryResultListByStudentId(studentList..getStudentId()));*/
        }
        return null;
    }

    private List<Integer> getResultIdList () {
        return iResultDao.queryResultIdList();
    }
}
