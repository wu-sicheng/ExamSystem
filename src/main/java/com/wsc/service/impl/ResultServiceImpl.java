package com.wsc.service.impl;

import com.wsc.dao.inter.IResultDao;
import com.wsc.exceptions.ManagerException;
import com.wsc.exceptions.ResultException;
import com.wsc.pojo.Result;
import com.wsc.service.inter.IPersonService;
import com.wsc.service.inter.IResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     *
     * @param powerId
     * @param result  结果
     * @return 是否创建成功
     */
    @Override
    public boolean createResult(int powerId, Result result) {
        if(iPersonService.createResult(powerId)){
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
        LOGGER.info("权限值为"+powerId+",没有创建result的权限");
        throw new ManagerException("权限值为"+powerId+",没有创建result的权限");
    }

    /**
     * 通过id删除一个结果，将state置为0，添加删除时间
     *
     * @param powerId
     * @param resultId 删除的id
     * @return 删除的结果
     */
    @Override
    public Result deleteResult(int powerId, int resultId) {
        if(iPersonService.deleteResult(powerId)){
            resultIdList=getResultIdList();
            if(resultIdList.contains(resultId)){
                Result resultRe=iResultDao.queryResult(resultId);
                iResultDao.deleteResult(resultId);
                return resultRe;
            }
            else{
                LOGGER.info("数据库result不包含数据result_id为"+resultId+"的数据");
                throw new ResultException("数据库result不包含数据result_id为"+resultId+"的数据");
            }
        }
        LOGGER.info("权限值为"+powerId+",没有创建result的权限");
        throw new ManagerException("权限值为"+powerId+",没有创建result的权限");
    }

    /**
     * 通过resultId更新结果
     * @param powerId
     * @param result
     * @return 更新前的结果
     */
    @Override
    public Result updateResult(int powerId,Result result) {
        if(iPersonService.updateResult(powerId)){
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
        LOGGER.info("权限值为"+powerId+",没有创建result的权限");
        throw new ManagerException("权限值为"+powerId+",没有创建result的权限");
    }

    /**
     * 通过id来查询一个结果
     *
     * @param powerId
     * @param resultId id
     * @return 查询到的结果
     */
    @Override
    public Result queryResult(int powerId, int resultId) {
        if(iPersonService.queryResult(powerId)){
            resultIdList=getResultIdList();
            if(resultIdList.contains(resultId)){
                return iResultDao.queryResult(resultId);
            }
            else{
                LOGGER.info("数据库result中不存在result_id为"+resultId+"的数据");
                throw new ResultException("数据库result中不存在result_id为"+resultId+"的数据");
            }
        }
        LOGGER.info("权限值为"+powerId+",没有创建result的权限");
        throw new ManagerException("权限值为"+powerId+",没有访问result的权限");
    }

    /**
     * 查询结果集
     *
     * @param powerId
     * @param fromResultId 开始的id
     * @param toResultId   结束的id
     * @return 查询的id
     */
    @Override
    public List<Result> queryResultList(int powerId, int fromResultId, int toResultId) {
        if(iPersonService.queryResult(powerId)){
            List<Result> results=iResultDao.queryResultList(fromResultId,toResultId);
            try{
                if(results.get(0)!=null){
                    return iResultDao.queryResultList(fromResultId,toResultId);
                }
            }catch (IndexOutOfBoundsException e){
                LOGGER.info(e.getMessage());
                LOGGER.info("数据库result找不到符合from_result_id:"+fromResultId+"到to_result_id:"+toResultId+"的数据");
                throw new ResultException("数据库result找不到符合from_result_id:"+fromResultId+"到to_result_id:"+toResultId+"的数据");
            }
        }
        LOGGER.info("权限值为"+powerId+",没有创建result的权限");
        throw new ManagerException("权限值为"+powerId+",没有访问result的权限");
    }

    @Override //TODO
    public List<Result> queryResultListByStudentId(int powerId, int studentId) {
        if(iPersonService.queryResult(powerId)){
            return iResultDao.queryResultList(fromResultId,toResultId);
        }
        LOGGER.info("权限值为"+powerId+",没有创建result的权限");
        throw new ManagerException("权限值为"+powerId+",没有访问result的权限");
    }

    @Override
    public List<Result> queryResultListByPaperId(int powerId, int studentId) {
        return null;
    }

    private List<Integer> getResultIdList(){
        return iResultDao.queryResultIdList();
    }

}
