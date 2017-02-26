package com.wsc.web;

import com.wsc.pojo.Paper;
import com.wsc.pojo.Question;
import com.wsc.pojo.Subject;
import com.wsc.service.inter.ITestDBService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wsc on 17-1-30.
 * 题库管理接口
 */
@RequestMapping("/test-db")
@Controller
public class TestDBController {

    @Autowired
    private ITestDBService iTestDBService;

    /*
     * 试题
     */
    @RequiresRoles(value ={"teacher","admin"},logical = Logical.OR)
    @RequestMapping(value = "/question/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Question createQuestion(@RequestBody Question question){
        try {
            iTestDBService.createQuestion(question);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return question;
    }

    @RequiresRoles(value ={"teacher","admin"},logical = Logical.OR)
    @RequestMapping(value = "/question/create/list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Question> createQuestionList(@RequestBody Set<Question> questions){
        Iterator<Question> questionIterator=questions.iterator();
        while(questionIterator.hasNext()){
            createQuestion(questionIterator.next());
        }
        return questions;
    }

    @RequiresRoles(value ={"admin"})
    @RequestMapping(value = "/question/delete/{questionId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Question deleteQuestion(@PathVariable int questionId){
        return iTestDBService.deleteQuestion(questionId);
    }

    @RequiresRoles(value ={"admin","teacher"},logical = Logical.OR)
    @RequestMapping(value = "/question/update/",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Question updateQuestion(@RequestBody Question question){
        return iTestDBService.updateQuestion(question);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/question/id/{questionId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Question queryQuestion(@PathVariable int questionId){
        return iTestDBService.queryQuestion(questionId);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/question/type/{questionType}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Question> queryQuestionByQuestionType(@PathVariable int questionType){
        return iTestDBService.queryQuestionByQuestionType(questionType);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/question/{fromQuestionId}/to/{toQuestionId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Question> queryQuestionList(@PathVariable int fromQuestionId,@PathVariable int toQuestionId){
        return iTestDBService.queryQuestionList(fromQuestionId,toQuestionId);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/question/all",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Question> queryQuestionAll(){
        return iTestDBService.queryQuestionAll();
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/question/subject/{subjectId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Question> queryQuestionListBySubject(@PathVariable int subjectId){
        return iTestDBService.queryQuestionListBySubject(subjectId);
    }

    //TODO
    File outPutQuestionBySubject(int subjectId){
        return null;
    }

    //TODO
    void inputQuesrtionByExcel(File file){}


    /* 试卷*/

    @RequiresRoles(value ={"admin","teacher"},logical = Logical.OR)
    @RequestMapping(value = "/paper/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Paper createPaper(@RequestBody Paper paper){
        Paper paperRe=null;
        try {
            paperRe =iTestDBService.createPaper(paper);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return paperRe;
    }

    //TODO
    void createPaperTemple1(String questionId){}

    //TODO
    void createPaperTemple2(String questionId){}

    //TODO
    void createPaperTemple3(String questionId){}

    @RequiresRoles(value ={"admin"})
    @RequestMapping(value = "/paper/delete/{paperId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Paper deletePaper(@PathVariable int paperId){
        return iTestDBService.deletePaper(paperId);
    }

    @RequiresRoles(value ={"admin","teacher"},logical = Logical.OR)
    @RequestMapping(value = "/paper/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Paper updatePaper(@RequestBody Paper paper){
        return iTestDBService.updatePaper(paper);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/paper/{paperId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Paper queryPaper(@PathVariable int paperId){
        return iTestDBService.queryPaper(paperId);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/paper/{fromPaperId}/to/{toPaperId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Paper> queryPaperList(@PathVariable int fromPaperId,@PathVariable int toPaperId){
        return iTestDBService.queryPaperList(fromPaperId,toPaperId);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/paper/all",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Paper> queryPaperAll(){
        return iTestDBService.queryPaperAll();
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/paper/subject/{subjectId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Paper> queryPaperBySubjectId(@PathVariable int subjectId){
        return iTestDBService.queryPaperBySubjectId(subjectId);
    }

    //TODO
    File outputPaperByPaperId(int paperId){
        return null;
    }


     /* 科目*/

    @RequiresRoles(value ={"admin","teacher"},logical = Logical.OR)
    @RequestMapping(value = "/subject/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Subject createSubject(@RequestBody Subject subject){
        Subject subjectRe=null;
        try {
            subjectRe = iTestDBService.createSubject(subject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @RequiresRoles(value ={"admin"})
    @RequestMapping(value = "/subject/delete/{subjectId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Subject deleteSubject(@PathVariable int subjectId){
        return iTestDBService.deleteSubject(subjectId);
    }

    @RequiresRoles(value ={"admin","teacher"},logical = Logical.OR)
    @RequestMapping(value = "/subject/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Subject updateSubject(@RequestBody Subject subject){
        return iTestDBService.updateSubject(subject);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Subject querySubject(@PathVariable int subjectId){
        return iTestDBService.deleteSubject(subjectId);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/subject/{fromSubjectId}/to/{toSubjectId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Subject> querySubjectList(@PathVariable int fromSubjectId,@PathVariable int toSubjectId){
        return iTestDBService.querySubjectList(fromSubjectId,toSubjectId);
    }

    @RequiresRoles(value ={"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "/subject/all",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Set<Subject> querySubjectAll(){
        return iTestDBService.querySubjectAll();
    }
}
