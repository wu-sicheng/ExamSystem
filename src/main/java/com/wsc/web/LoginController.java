package com.wsc.web;

import com.wsc.dto.Register;
import com.wsc.dto.login.LoginDTO;
import com.wsc.pojo.Student;
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
    private String loginType;

    @Autowired
    private IPersonService iPersonService;

    //登录
    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public String login(LoginDTO loginDTO, Model model) {
        LOGGER.info("进入登录验证");
        Subject subject = SecurityUtils.getSubject();
        String mail=null;
        String mailRegex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        String phoneRegex="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        String account=loginDTO.getAccount();
        String role=loginDTO.getRole();
        loginType=role;
        LOGGER.info("登录的角色为"+role);
        if("teacher".equals(role)||"admin".equals(role)) {
            LOGGER.info("匹配教师或者管理员");
            if (account.matches(mailRegex)) {//mail
                LOGGER.info("匹配为mail");
                mail = account;
            } else if (account.matches(phoneRegex)) {//phone
                LOGGER.info("匹配为phone");
                mail = iPersonService.queryTeacherByPhone(account).getTeacherMail();
                LOGGER.info("登录的mail地址为" + mail);
            } else {//name
                LOGGER.info("匹配为name");
                mail = iPersonService.queryTeacherByName(account).getTeacherMail();
                LOGGER.info("登录的mail地址为" + mail);
            }
        }
        else if("student".equals(role)) {
            LOGGER.info("匹配学生");
            if (account.matches(mailRegex)) {//mail
                LOGGER.info("匹配为mail");
                mail = account;
            } else if (account.matches(phoneRegex)) {//phone
                LOGGER.info("匹配为phone");
                mail = iPersonService.queryStudentByPhone(account).getStudentMail();
                LOGGER.info("登录的mail地址为" + mail);
            } else {//name
                LOGGER.info("匹配为name");
                mail = iPersonService.queryStudentByStudentName(account).getStudentMail();
                LOGGER.info("登录的mail地址为" + mail);
            }
        }
        UsernamePasswordToken token = new UsernamePasswordToken(mail, Encryption.md5En(loginDTO.getPassword()));
        try {
            subject.login(token);
        } catch (Exception e) {
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//          e.printStackTrace();
            model.addAttribute("error", "用户名或密码错误");
            LOGGER.info("shirｏ验证不通过，用户名或密码错误");
            return "/error";
        }
        if("admin".equals(loginDTO.getRole())){
            model.addAttribute("name",loginDTO.getAccount());
            model.addAttribute("password",loginDTO.getPassword());
            model.addAttribute("role",loginDTO.getRole());
            return "/background/admin/admin";
        }
        else if ("teacher".equals(loginDTO.getRole())){
            model.addAttribute("name",loginDTO.getAccount());
            model.addAttribute("password",loginDTO.getPassword());
            model.addAttribute("role",loginDTO.getRole());
            return "/proscenium/teacher/teacher";
        }
        else if ("student".equals(loginDTO.getRole())){
            model.addAttribute("name",loginDTO.getAccount());
            model.addAttribute("password",loginDTO.getPassword());
            model.addAttribute("role",loginDTO.getRole());
            return "/proscenium/student/student";
        }
        else if ("guest".equals(loginDTO.getRole())){
            model.addAttribute("name",loginDTO.getAccount());
            model.addAttribute("password",loginDTO.getPassword());
            model.addAttribute("role",loginDTO.getRole());
            return "/proscenium/student/student";
        }
        return "mess";
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Register register,Model model){
        if("teacher".equals(register.getRole())){
            Set<String> teacherMail=iPersonService.queryListTeacherMail();
            LOGGER.info(teacherMail.toString());
            if(!teacherMail.contains(register.getMail())){
                LOGGER.info(register.getMail());
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
                return "/error";
            }
        }
        else if("student".equals(register.getRole())){
            Set<String> studentMail = iPersonService.queryListStudentMail();
            if (!studentMail.contains(register.getMail())) {
                Student student=new Student();
                student.setStudentMail(register.getMail());
                student.setStudentDisplayName(register.getMail());
                student.setStudentPassword(Encryption.md5En(register.getPassword()));
                iPersonService.createStudent(student);
                model.addAttribute("name", register.getMail());
                return "mess";
            }
            else {
                model.addAttribute("error", "数据库中含有邮箱地址为" + register.getMail() + "的数据,请更换邮箱地址注册");
                return "/error";
            }
        }
        model.addAttribute("error", "数据库中含有邮箱地址为" + register.getMail() + "的数据,请更换邮箱地址注册");
        return "/error";
    }

    @RequestMapping(value = "/addMess",method = RequestMethod.POST)
    public String addMess(@ModelAttribute("SpringWeb") Teacher teacher,Model model){
        model.addAttribute("name",teacher.getTeacherName());
        model.addAttribute("password",teacher.getTeacherPassword());
        return "mess";
    }

    public String getLoginType(){
        return loginType;
    }

/*    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("teacher", "command", new Teacher());
    }*/
}
