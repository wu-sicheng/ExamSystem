package com.wsc.service.impl;

import com.wsc.dto.ResultRe;
import com.wsc.pojo.Question;
import com.wsc.service.inter.IPersonService;
import com.wsc.service.inter.IResultService;
import com.wsc.service.inter.IScoreService;
import com.wsc.service.inter.ITestDBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wsc on 17-1-26.
 * 题目类型：1单选，2多选，3填空，4对错，5论述，6 OJ（待定）
 */
@Service
public class ScoreServiceImpl implements IScoreService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ScoreServiceImpl.class);

    @Autowired
    private IPersonService iPersonService;

    @Autowired
    private IResultService iResultService;

    @Autowired
    private ITestDBService iTestDBService;

    @Override
    public void reResultRe(ResultRe resultRe) {

    }

    @Override
    public double computeScore(int powerId,ResultRe.QuestionRe questionRe) {
        if(iPersonService.queryTestDB(powerId)&&iPersonService.createTestDB(powerId)&&
                iPersonService.queryResult(powerId)&&iPersonService.createResult(powerId)){
            Question question=iTestDBService.queryQuestion(powerId,questionRe.getQuestionId());
            double fullScore=question.getQuestionScore();
            if(question.getQuestionType()==1){//单选，选对得分，选错不得分
                if(questionRe.getAnswer().equals(question.getQuestionAnswer())){
                    return fullScore;
                }
                else{
                    return 0L;
                }
            }
            else if(question.getQuestionType()==2){//多选，选对得满分，选少没选错得一半分，选多或选错不得分

            }
            else if(question.getQuestionType()==3){//填空，题目n个空，填对m个得m/n*fullScore分，支持教师改卷

            }
            else if(question.getQuestionType()==4){//对错题，选对得满分，选错不得分
                if(questionRe.getAnswer().equals(question.getQuestionAnswer())){
                    return fullScore;
                }
                else{
                    return 0L;
                }
            }
            else if(question.getQuestionType()==5){//论述题，匹配n个关键词，匹配到m个得m/n*fullScore分，支持教师改卷

            }
            else if(question.getQuestionType()==6){//OJ(待实现)//TODO OJ

            }
        }
    }

    @Override
    public boolean storeResultDetial(ResultRe resultRe) {
        return false;
    }
}
