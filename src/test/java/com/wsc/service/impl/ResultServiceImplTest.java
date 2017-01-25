package com.wsc.service.impl;

import com.wsc.pojo.Result;
import com.wsc.service.inter.IResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
 * Created by wsc on 17-1-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class ResultServiceImplTest {
    private static final Logger LOGGER= LoggerFactory.getLogger(ResultServiceImplTest.class);
    @Resource
    private IResultService iResultService;

    @Test
    public void createResult() throws Exception {
        Result result=new Result(5,1,1,1,"str",new Date(),new Date(),1);
        iResultService.createResult(1,result);
    }

    @Test
    public void deleteResult() throws Exception {
        iResultService.deleteResult(1,1);
    }

    @Test
    public void updateResult() throws Exception {
        Result result=new Result(2,1,1,1,"changeStr",new Date(),new Date(),1);
        iResultService.updateResult(1,result);
    }

    @Test
    public void queryResult() throws Exception {
        Result result=iResultService.queryResult(1,1);
        LOGGER.info(result.toString());
    }

    @Test
    public void queryResultList() throws Exception {
        List<Result> results=iResultService.queryResultList(1,1,2);
        LOGGER.info(results.toString());
    }

    @Test
    public void queryResultListByStudentId() throws Exception {

    }

    @Test
    public void queryResultListByPaperId() throws Exception {

    }

}