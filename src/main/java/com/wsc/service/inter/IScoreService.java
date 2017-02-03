package com.wsc.service.inter;

import com.wsc.dto.ResultRe;

/**
 * Created by wsc on 17-1-26.
 * 分数统计的服务接口
 * 主要的功能是：
 * 接收考生数据，计算分数，调用resultService和paperSerivce将数据传入到resultDetail中
 * 题目类型：1单选，2多选，3填空，4对错，5论述，6 OJ（待定）
 */
public interface IScoreService {
    /*
    考生考试数据
     */
    void reResultRe(ResultRe resultRe);

    /*
    计算分数
     */
    //选择
    double computeScore(ResultRe.QuestionRe questionRe);

    //多选

    //填空

    //论述

    //OJ（待定）


    /*
    数据存储
     */
    boolean storeResultDetial(ResultRe resultRe);
}
