package com.wsc.service.inter;

import com.wsc.dto.Exam;
import com.wsc.dto.ExamMess;
import com.wsc.dto.ExamPaper;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
public interface IExamService {
    /*
    考试的试题
     */
    ExamPaper getExamPaper(int powerId,int paperId);

    /*
    学生考试的相关信息
     */
    List<ExamMess> getExamMess(int powerId,int studentId);

    /*
    考试学生的做题
     */


}
