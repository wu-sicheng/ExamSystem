package com.wsc.service.impl;

import com.wsc.dto.ExamMess;
import com.wsc.dto.ExamPaper;
import com.wsc.exceptions.ManagerException;
import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.pojo.Student;
import com.wsc.service.inter.IExamService;
import com.wsc.service.inter.IPersonService;
import com.wsc.service.inter.ITestDBService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ExamPaper getExamPaper(int paperId) {
        Paper paper=iTestDBService.queryPaper(paperId);
        DateTime begin=new DateTime(paper.getPaperTimeBegin());
        DateTime end=new DateTime(paper.getPaperTimeEnd());
        List<Question> questions=new ArrayList<>();
        String questionStr=iTestDBService.queryPaper(paperId).getQuestionId();
        String[] questionList=questionStr.split(",");
        for(int i=0;i<questionList.length;i++){
            questions.add(iTestDBService.queryQuestion(Integer.valueOf(questionList[i])));
        }
        ExamPaper examPaper=new ExamPaper(begin,end,questions);
        return examPaper;
    }

    @Override
    public List<ExamMess> getExamMess(int studentId) {
        Student student=iPersonService.queryStudentByStudentId(studentId);
        List<ExamMess> examMesses=new ArrayList<>();
        String[] paperIdStr=student.getPaperId().split(",");
        for(int i=0;i<paperIdStr.length;i++){
            Paper paper=iTestDBService.queryPaper(Integer.valueOf(paperIdStr[i]));
            DateTime begin=new DateTime(paper.getPaperTimeBegin());
            DateTime end=new DateTime(paper.getPaperTimeEnd());
            String paperName=iTestDBService.querySubject(paper.getSubjectId()).getSubjectName();
            int paperId=iTestDBService.queryPaper(paper.getPaperId()).getPaperId();
            ExamMess examMess=new ExamMess(begin,end,paperName,paperId);
            examMesses.add(examMess);
        }
        return examMesses;
    }

    @Override
    public boolean canExam(int studentId,int paperId) {
        Student student = iPersonService.queryStudentByStudentId(studentId);
        List<ExamMess> examMesses = new ArrayList<>();
        Paper paper = iTestDBService.queryPaper(paperId);
        DateTime now = DateTime.now();
        DateTime begin = new DateTime(paper.getPaperTimeBegin());
        DateTime end = new DateTime(paper.getPaperTimeEnd());
        LOGGER.info("now:" + now.toString() + ",begin:" + begin + ",end:" + end);
        if (now.isBefore(begin)) {
            LOGGER.info("离考试开始还有" + (begin.minus(now.getMillis())) + "分钟");
            return false;
        } else if (now.isAfter(begin) && now.isBefore(begin.plusMillis(15))) {
            LOGGER.info("允许考试");
            return true;
        } else if (now.isAfter(begin.plusMillis(15)) && now.isBefore(end)) {
            LOGGER.info("考试中，不允许考试");
            return false;
        }else{
            LOGGER.info("考试结束，不允许考试");
            return false;
        }
    }
}
