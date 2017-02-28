package com.wsc.web;

import com.wsc.dto.ExamPaper;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wsc on 17-1-30.
 * 考试的相关接口
 */
@RequestMapping("/exam")
@Controller
public class ExamController {

    @Autowired
    private IPersonService iPersonService;

    @RequiresRoles(value ={"student"},logical = Logical.OR)
    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher getTeacherById(@PathVariable int id){
        Teacher teacher=iPersonService.queryTeacherByTeacherId(id);
        return teacher;
    }




}
