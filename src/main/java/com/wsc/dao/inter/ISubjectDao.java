package com.wsc.dao.inter;

import com.wsc.pojo.Subject;
import java.util.List;

/**
 * Created by wsc on 17-1-16.
 */
public interface ISubjectDao {
    boolean createSubject(Subject subject);
    void deleteSubject(int subjectId);
    Subject updateSubject(Subject subject);
    Subject querySubject(int subjectId);
    List<Subject> querySubjectList(int formSubjectId,int manySubjectId);

    List<Integer> querySubjectIdList();
}
