package com.wsc.service.impl;

import com.wsc.dao.inter.IPaperDao;
import com.wsc.enums.ExamState;
import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.service.inter.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wsc on 17-1-17.
 */
public class PaperServiceImpl implements IPaperService {

    private IPaperDao iPaperDao;

    @Override
    public boolean createPaper(Paper paper) {
        return false;
    }

    @Override
    public Paper deletePaper(int paperId) {
        return null;
    }

    @Override
    public Paper updatePaper(int paperId, Paper paper) {
        return null;
    }

    @Override
    public Paper queryPaper(int paperId) {
        return null;
    }

    @Override
    public List<Paper> queryPaperList(int fromPaperId, int manyPaperId) {
        return null;
    }

    @Override
    public boolean isDelete(int paperId) {
        return false;
    }

    @Override
    public List<Question> getQuestionByPaperId(int paperId) {
        return null;
    }

    @Override
    public List<Paper> getPaperBySubjectId(int subjectId) {
        return null;
    }

    @Override
    public ExamState isExam(int paperId) {
        return null;
    }
}
