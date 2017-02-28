package com.wsc.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wsc on 17-2-27.
 */
@RequestMapping("/proscenium")
@Controller
public class StudentController {

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/practise",method = RequestMethod.GET)
    public String practise(){
        return "/proscenium/student/practise";
    }

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/exam",method = RequestMethod.GET)
    public String exam(){
        return "/proscenium/student/exam";
    }

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/result",method = RequestMethod.GET)
    public String result(){
        return "/proscenium/student/result";
    }

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/examNotify",method = RequestMethod.GET)
    public String examNotify(){
        return "/proscenium/student/examNotify";
    }

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/personalZone",method = RequestMethod.GET)
    public String personalZone(){
        return "/proscenium/student/personalZone";
    }

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/settings",method = RequestMethod.GET)
    public String settings(){
        return "/proscenium/student/settings";
    }

    @RequiresRoles(value ={"student"})
    @RequestMapping(value = "/student/logout",method = RequestMethod.GET)
    public String logout(){
        return "/proscenium/student/logout";
    }



}
