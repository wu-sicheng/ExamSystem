package com.wsc.web;

import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by wsc on 17-1-28.
 */
@Controller
@RequestMapping("/init")
public class InitController {

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Teacher> list=iPersonService.queryTeacherAll();
        model.addAttribute("list",list);
        return "list";
    }
}
