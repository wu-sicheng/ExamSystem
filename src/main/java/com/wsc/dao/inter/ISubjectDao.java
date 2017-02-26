package com.wsc.dao.inter;

import com.wsc.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-16.
 */
public interface ISubjectDao {
    boolean createSubject(Subject subject);
    void deleteSubject(int subjectId);
    void updateSubject(Subject subject);
    Subject querySubject(int subjectId);
    Set<Subject> querySubjectList(@Param("fromSubjectId") int fromSubjectId,@Param("toSubjectId") int toSubjectId);

    Set<Integer> querysubjectIdSet();
    Set<String> querySubjectNames();
}
