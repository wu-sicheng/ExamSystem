package com.wsc.service.impl;

import com.wsc.dto.ExamMess;
import com.wsc.dto.ExamPaper;
import com.wsc.exceptions.ManagerException;
import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.service.inter.IExamService;
import com.wsc.service.inter.IPersonService;
import com.wsc.service.inter.ITestDBService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsc on 17-1-24.
 */
@Service
public class ExamServiceImpl implements IExamService{
    private static final Logger LOGGER= LoggerFactory.getLogger(ExamServiceImpl.class);

    @Autowired
    private IPersonService iPersonService;

    @Autowired
    private ITestDBService iTestDBService;

    @Override
    public ExamPaper getExamPaper(int powerId, int paperId) {
        if(iPersonService.queryTestDB(powerId)){
            Paper paper=iTestDBService.queryPaper(powerId,paperId);
            DateTime begin=new DateTime(paper.getPaperTimeBegin());
            DateTime end=new DateTime(paper.getPaperTimeEnd());
            List<Question> questions=new ArrayList<>();
            String questionStr=iTestDBService.queryPaper(powerId,paperId).getQuestionId();
            String[] questionList=questionStr.split(",");
            for(int i=0;i<questionList.length;i++){
                questions.add(iTestDBService.queryQuestion(powerId,Integer.valueOf(questionList[i])));
            }
            ExamPaper examPaper=new ExamPaper(begin,end,questions);
            return examPaper;
        }
        else{
            LOGGER.info("powerId为"+powerId+"没有查询试卷的权限");
            throw new ManagerException("powerId为"+powerId+"没有查询试卷的权限");
        }
    }

    @Override
    public List<ExamMess> getExamMess(int powerId, int studentId) {
        return null;
    }
}
