package com.wsc.service.inter;

import com.wsc.dto.Exam;
import com.wsc.dto.ExamMess;
import com.wsc.dto.ExamPaper;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by wsc on 17-1-18.
 * 考务管理接口，主要的功能包括组卷，查询考试信息，监控考试
 */
public interface IExamService {
    /*
    考试的试题
     */
    ExamPaper getExamPaper(int powerId,int paperId);

    /*
    学生考试的相关信息
     */
    List<ExamMess> getExamMess(int studentId);

    /*
    考试学生的做题
     */
    boolean canExam(int studentId,int paperId);





}
