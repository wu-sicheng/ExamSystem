package com.wsc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wsc on 17-2-22.
 */
@RequestMapping("/background")
@Controller
public class BackgroundController {
    /*
    * 教师，学生，班级，权限
    * */
    @RequestMapping(value = "/admin/powerManager",method = RequestMethod.GET)
    public String powerManager(){
        return "background/admin/powerManager";
    }

    @RequestMapping(value = "/admin/teacherMess",method = RequestMethod.GET)
    public String teacherMess(){
        return "/background/admin/teacherMess";
    }

    @RequestMapping(value = "/admin/personContro/teacherClassMess",method = RequestMethod.GET)
    public String teacherClassMess(){
        return "/background/admin/personContro/teacherClassMess";
    }

    @RequestMapping(value = "/admin/personContro/teacherPaperMess",method = RequestMethod.GET)
    public String teacherPaperMess(){
        return "/background/admin/personContro/teacherPaperMess";
    }


    @RequestMapping(value = "/admin/personContro/studentMess",method = RequestMethod.GET)
    public String studentMess(){
        return "/background/admin/personContro/studentMess";
    }

    @RequestMapping(value = "/admin/personContro/studentPaperMess",method = RequestMethod.GET)
    public String studentPaperMess(){
        return "/background/admin/personContro/studentPaperMess";
    }

    @RequestMapping(value = "/admin/personContro/studentClassMess",method = RequestMethod.GET)
    public String studentClassMess(){
        return "/background/admin/personContro/studentClassMess";
    }

    @RequestMapping(value = "/admin/personContro/registCheck",method = RequestMethod.GET)
    public String registCheck(){
        return "/background/admin/personContro/registCheck";
    }

    @RequestMapping(value = "/admin/personContro/teacherPermiss",method = RequestMethod.GET)
    public String teacherPermiss(){
        return "/background/admin/personContro/teacherPermiss";
    }

    @RequestMapping(value = "/admin/personContro/studentPermiss",method = RequestMethod.GET)
    public String studentPermiss(){
        return "/background/admin/personContro/studentPermiss";
    }

    @RequestMapping(value = "/admin/personContro/classMess",method = RequestMethod.GET)
    public String classMess(){
        return "/background/admin/personContro/classMess";
    }


    /*
    试卷，试题，科目
    * */
    @RequestMapping(value = "/admin/testDBContro/paperMess",method = RequestMethod.GET)
    public String paperMess(){
        return "/background/admin/testDBContro/paperMess";
    }

    @RequestMapping(value = "/admin/testDBContro/questionMess",method = RequestMethod.GET)
    public String questionMess(){
        return "/background/admin/testDBContro/questionMess";
    }


    @RequestMapping(value = "/admin/testDBContro/subjectMess",method = RequestMethod.GET)
    public String subjectMess(){
        return "/background/admin/testDBContro/subjectMess";
    }
}
