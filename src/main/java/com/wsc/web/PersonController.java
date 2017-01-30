package com.wsc.web;

import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wsc on 17-1-30.
 * 人员管理接口
 */
@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody Teacher getTeacherById(@PathVariable int id){
        Teacher teacher=iPersonService.queryTeacherByTeacherId(id);
        return teacher;
    }

/*    @RequestMapping(value = "/teacher/list",method = RequestMethod.GET,produces = "application/json,charset=UTF-8")
    @ResponseBody
    public List<Teacher> getTeacher(){
        List<Teacher> list=iPersonService.queryTeacherAll();
        return list;
    }*/
}
