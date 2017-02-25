package com.wsc.web;

import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.pojo.Subject;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.ITestDBService;
import com.wsc.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

/**
 * Created by wsc on 17-1-30.
 * 题库管理接口
 */
@RequestMapping("/test-db")
@Controller
public class TestDBController {

    @Autowired
    private ITestDBService iTestDBService;

    /*    @RequiresRoles(value ={"teacher","admin"},logical = Logical.OR)*/
    @RequestMapping(value = "/teacher/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher createTeacher(@RequestBody Teacher teacher){
        teacher.setTeacherPassword(Encryption.md5En(teacher.getTeacherPassword()));
        iPersonService.createTeacher(teacher);
        return teacher;
    }

    /*
     * 试题
     */
    @RequestMapping(value = "/question/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Question createQuestion(Question question){
        iTestDBService.createQuestion(question);
        return question;
    }

    void createQuestionList(List<Question> questions){}

    Question deleteQuestion(int questionId){

    }

    Question updateQuestion(int questionId,Question question){}

    Question queryQuestion(int questionId){}

    List<Question> queryQuestionByQuestionType(int questionType){}

    List<Question> queryQuestionList(int fromQuestionId, int manyQuestionId){}

    List<Question> queryQuestionListBySubject(int subjectId){}

    File outPutQuestionBySubject(int subjectId){}

    void inputQuesrtionByExcel(File file){}


    /* 试卷*/


    boolean createPaper(Paper paper){}

    void createPaperTemple1(String questionId){}

    void createPaperTemple2(String questionId){}

    void createPaperTemple3(String questionId){}

    Paper deletePaper(int paperId){}

    Paper updatePaper(int paperId,Paper paper){}

    Paper queryPaper(int paperId){}

    List<Paper> queryPaperList(int fromPaperId,int manyPaperId){}

    List<Paper> queryPaperBySubjectId(int subjectId){}

    File outputPaperByPaperId(int paperId){}


     /* 科目*/

    boolean createSubject(Subject subject){}

    Subject deleteSubject(int subjectId){}

    Subject updateSubject(Subject subject){}

    Subject querySubject(int subjectId){}

    List<Subject> querySubjectList(int formSubjectId,int manySubjectId){}
}
