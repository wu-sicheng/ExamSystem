package com.wsc.dao.inter;

import com.wsc.pojo.Paper;

/**
 * Created by wsc on 17-1-13.
 */
public interface IPaperDao {
    boolean createPaper(Paper paper);
    Paper deletePaper(int paperId);
    Paper updatePaper(int paperId,Paper paper);
    Paper queryPaper(int paperId);
}
