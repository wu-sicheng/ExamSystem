package com.wsc.dao.inter;

import com.wsc.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-13.
 */
public interface IPaperDao {
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
    void deletePaper(int paperId);

    /**
     * 更新试卷参数
     * @param paper 更新后的试卷的详情
     * @return 更新后试卷的参数
     */
    void updatePaper(Paper paper);

    /**
     * 通过paperId查询一份试卷
     * @param paperId
     * @return
     */
    Paper queryPaper(int paperId);

    /**
     * 查询试题
     * @param fromPaperId 开始的paperId
     * @param  toPaperId 数量
     * @return 查询到的paper
     */
    Set<Paper> queryPaperList(@Param("fromPaperId") int fromPaperId,@Param("toPaperId") int toPaperId);

    Set<Integer> querypaperIdSet();

    Set<Paper> queryPaperBySubjectId(int subjectId);

    Set<String> queryPaperName();
}
