package com.wsc.web;

import com.wsc.pojo.Teacher;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wsc on 17-2-3.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute("SpringWeb") Teacher teacher, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(teacher.getTeacherName(),teacher.getTeacherPassword());
        try {
            subject.login(token);
            model.addAttribute("name",teacher.getTeacherName());
            model.addAttribute("password",teacher.getTeacherPassword());
            return "mess";
        } catch (Exception e) {
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//          e.printStackTrace();
            model.addAttribute("error", "用户名或密码错误");
            return "admin";
        }
    }

    @RequestMapping(value = "/addMess",method = RequestMethod.POST)
    public String addMess(@ModelAttribute("SpringWeb") Teacher teacher,Model model){
        model.addAttribute("name",teacher.getTeacherName());
        model.addAttribute("password",teacher.getTeacherPassword());
        return "mess";
    }

/*    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("teacher", "command", new Teacher());
    }*/
}
