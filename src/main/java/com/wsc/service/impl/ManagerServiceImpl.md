package com.wsc.service.impl;

import com.wsc.dao.inter.IManagerDao;
import com.wsc.exceptions.ManagerException;
import com.wsc.pojo.Manager;
import com.wsc.service.inter.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by wsc on 17-1-16.*/


@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private IManagerDao iManagerDao;

    List<Manager> managerList=iManagerDao.queryAllManager();
    List<Integer> idList=queryIdList();
    List<Integer> managerIdList=queryManagerIdList();

    public ManagerServiceImpl() {
    }

    public ManagerServiceImpl(IManagerDao iManagerDao){
        this.iManagerDao=iManagerDao;
    }

    @Override
    public int createPower(Manager manager) throws ManagerException{
        manager.setManagerId(Collections.max(managerIdList)+1);
        iManagerDao.createPower(manager);
        return judgePower(manager.getManagerId());
    }

    @Override
    public int deletePower(int managerId) {
        if(managerIdList.contains(managerId)){
            int power=iManagerDao.judgePower(managerId);
            if(power>3){
                iManagerDao.deletePower(power);
                return power;
            }
            else if(0<power&&power<=3){
                throw new ManagerException("不能删除1-3的权限值");
            }
            return -1;
        }
        else{
            throw new ManagerException("没有所示的权限");
        }
    }

    @Override
    public int judgePower(int managerId) {
        return iManagerDao.judgePower(managerId);
    }

    @Override
    public boolean judgeCreateStudent(int managerId) {
        return getManagerByManagerId(managerId).getCreateStudent()==1;
    }

    @Override
    public boolean judgeCreateTeacher(int managerId) {
        return getManagerByManagerId(managerId).getCreateTeacher()==1;
    }

    @Override
    public boolean judgeCreatePaper(int managerId) {
        return getManagerByManagerId(managerId).getCreatePaper()==1;
    }

    @Override
    public boolean judgeCreateQuestion(int managerId) {
        return getManagerByManagerId(managerId).getCreateQuestion()==1;
    }

    @Override
    public boolean judgeCreateResult(int managerId) {
        return getManagerByManagerId(managerId).getCreateResult()==1;
    }

    @Override
    public boolean judgeCreateTheClass(int managerId) {
        return getManagerByManagerId(managerId).getCreateTheClass()==1;
    }

    @Override
    public boolean judgeDeleteStudent(int managerId) {
        return getManagerByManagerId(managerId).getDeleteResult()==1;
    }

    @Override
    public boolean judgeDeleteTeacher(int managerId) {
        return getManagerByManagerId(managerId).getDeleteTeacher()==1;
    }

    @Override
    public boolean judgeDeletePaper(int managerId) {
        return getManagerByManagerId(managerId).getDeletePaper()==1;
    }

    @Override
    public boolean judgeDeleteQuestion(int managerId) {
        return getManagerByManagerId(managerId).getDeleteQuestion()==1;
    }

    @Override
    public boolean judgeDeleteResult(int managerId) {
        return getManagerByManagerId(managerId).getDeleteResult()==1;
    }

    @Override
    public boolean judgeDeleteTheClass(int managerId) {
        return getManagerByManagerId(managerId).getDeleteTheClass()==1;
    }

    @Override
    public boolean judgeUpdateStudent(int managerId) {
        return getManagerByManagerId(managerId).getUpdateStudent()==1;
    }

    @Override
    public boolean judgeUpdateTeacher(int managerId) {
        return getManagerByManagerId(managerId).getUpdateTeacher()==1;
    }

    @Override
    public boolean judgeUpdatePaper(int managerId) {
        return getManagerByManagerId(managerId).getUpdatePaper()==1;
    }

    @Override
    public boolean judgeUpdateQuestion(int managerId) {
        return getManagerByManagerId(managerId).getUpdateQuestion()==1;
    }

    @Override
    public boolean judgeUpdateResult(int managerId) {
        return getManagerByManagerId(managerId).getUpdateResult()==1;
    }

    @Override
    public boolean judgeUpdateTheClass(int managerId) {
        return getManagerByManagerId(managerId).getUpdateTheClass()==1;
    }

    @Override
    public boolean judgeQueryStudent(int managerId) {
        return getManagerByManagerId(managerId).getQueryStudent()==1;
    }

    @Override
    public boolean judgeQueryTeacher(int managerId) {
        return getManagerByManagerId(managerId).getQueryTeacher()==1;
    }

    @Override
    public boolean judgeQueryPaper(int managerId) {
        return getManagerByManagerId(managerId).getQueryTeacher()==1;
    }

    @Override
    public boolean judgeQueryQuestion(int managerId) {
        return getManagerByManagerId(managerId).getQueryQuestion()==1;
    }

    @Override
    public boolean judgeQueryResult(int managerId) {
        return getManagerByManagerId(managerId).getQueryResult()==1;
    }

    @Override
    public boolean judgeQueryTheClass(int managerId) {
        return getManagerByManagerId(managerId).getQueryTheClass()==1;
    }

    @Override
    public boolean judgeManageState(int managerId) {
        return getManagerByManagerId(managerId).getManagerState()==1;
    }

    private Manager getManagerByManagerId(int managerId){
        return iManagerDao.queryManagerByManagerId(managerId);
    }

    private List<Integer> queryIdList() {
        return iManagerDao.queryIdList();
    }

    private List<Integer> queryManagerIdList(){
        return iManagerDao.queryManagerIdList();
    }
}
