package com.wsc.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.List;

/**
 * Created by wsc on 17-1-28.
 */
@Controller
@RequestMapping("/init")
public class InitController {

    @Autowired
    private IPersonService iPersonService;
    private ObjectMapper mapper=new ObjectMapper();

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Teacher> list=iPersonService.queryTeacherAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "/getTeacherList",method = RequestMethod.GET)
    public @ResponseBody List<Teacher> getTeacher(){
        List<Teacher> list=iPersonService.queryTeacherAll();
        return list;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody Teacher getTeacherById(@PathVariable  int id){
        Teacher teacher=iPersonService.queryTeacherByTeacherId(id);
        return teacher;
    }
}
