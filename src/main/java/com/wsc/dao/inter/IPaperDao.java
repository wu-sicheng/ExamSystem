package com.wsc.dao.inter;

import com.wsc.pojo.Paper;

import java.util.List;

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
     * @param  manypaperId 结束的paperId
     * @return 查询到的paper
     */
    List<Paper> queryPaperList(int fromPaperId,int manypaperId);
}
