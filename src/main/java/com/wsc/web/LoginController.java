package com.wsc.web;

import com.wsc.dto.Register;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import com.wsc.util.Encryption;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by wsc on 17-2-3.
 */
@Controller
public class LoginController {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IPersonService iPersonService;

    //登录
    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public String login(@ModelAttribute("SpringWeb") Teacher teacher, Model model) {
        LOGGER.info("进入登录验证");
        Subject subject = SecurityUtils.getSubject();
        String mail=null;
        String mailRegex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        String phoneRegex="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        String str=teacher.getTeacherName();
        if(str.matches(mailRegex)) {//mail
            LOGGER.info("匹配为mail");
            mail=str;
        }else if(str.matches(phoneRegex)){//phone
            LOGGER.info("匹配为phone");
            mail=iPersonService.queryTeacherByPhone(str).getTeacherMail();
            LOGGER.info("登录的mail地址为"+mail);
        }else{//name
            LOGGER.info("匹配为name");
            mail=iPersonService.queryTeacherByName(str).getTeacherMail();
            LOGGER.info("登录的mail地址为"+mail);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(mail, Encryption.md5En(teacher.getTeacherPassword()));
        try {
            subject.login(token);
            token.setRememberMe(true);
            model.addAttribute("name",teacher.getTeacherName());
            model.addAttribute("password",teacher.getTeacherPassword());
            return "mess";
        } catch (Exception e) {
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//          e.printStackTrace();
            model.addAttribute("error", "用户名或密码错误");
            return "background/admin/admin";
        }
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("SpringWeb")Register register,Model model){
        Set<String> emailSet=iPersonService.queryListTeacherMail();
        if(!emailSet.contains(register.getMail())){
            Teacher teacher=new Teacher();
            teacher.setTeacherMail(register.getMail());
            teacher.setTeacherDisplayName(register.getMail());
            teacher.setTeacherPassword(Encryption.md5En(register.getPassword()));
            iPersonService.createTeacher(teacher);
            model.addAttribute("name",register.getMail());
            return "mess";
        }
        else{
            model.addAttribute("error","数据库中含有邮箱地址为"+register.getMail()+"的数据,请更换邮箱地址注册");
            return "background/admin/admin";
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
