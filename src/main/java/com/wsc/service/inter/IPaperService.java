package com.wsc.service.inter;

import com.wsc.enums.ExamState;
import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;

import java.util.List;

/**
 * Created by wsc on 17-1-15.
 */
public interface IPaperService {
    /**
     * 创建一份试卷,将State置为1，添加创建的时间
     * @param paper 一份试卷参数
     * @return 是否创建成功
     */
    boolean createPaper(Paper paper);

    /**
     * 根据paperId删除一份试卷，只是将paperState由1改为0，并添加删除的时间
     * @param paperId
     * @return
     */
    Paper deletePaper(int paperId);

    /**
     * 更新试卷参数
     * @param paperId 试卷id
     * @param paper 更新后的试卷的详情
     * @return 更新后试卷的参数
     */
    Paper updatePaper(int paperId,Paper paper);

    /**
     * 通过paperId查询一份试卷
     * @param paperId
     * @return
     */
    Paper queryPaper(int paperId);

    /**
     * 查询试题
     * @param fromPaperId 开始的paperId
     * @param  manyPaperId 数量
     * @return 查询到的paper
     */
    List<Paper> queryPaperList(int fromPaperId, int manyPaperId);

    /**
     * 判断试卷是否删除
     * @param paperId
     * @return
     */
    boolean isDelete(int paperId);

    /**
     * 通过paperid获取问题列表
     * @param paperId
     * @return
     */
    List<Question> getQuestionByPaperId(int paperId);

    /**
     * 通过subjectid获取paper
     * @param subjectId
     * @return
     */
    List<Paper> getPaperBySubjectId(int subjectId);

    /**
     * 判断考试的状态，考试前，考试中，考试结束
     * @param paperId paperId
     * @return 考试状态
     */
    ExamState isExam(int paperId);
}
