package com.wsc.web;

import com.wsc.dto.DBMess;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IInitService;
import com.wsc.service.inter.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by wsc on 17-1-28.
 * 初始化相关操作
 * 包括数据库的配置
 * 管理员账号的配置
 */
@Controller
@RequestMapping("/init")
public class InitController {
    private static final Logger LOGGER= LoggerFactory.getLogger(InitController.class);

    @Autowired
    private IPersonService iPersonService;

    @Autowired
    private IInitService iInitService;

    @RequestMapping(value = "/manager",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher setManager(@RequestBody Teacher teacher){
        iPersonService.createTeacher(teacher);
        return iPersonService.queryTeacherByTeacherId(teacher.getTeacherId());
    }

    @RequestMapping(value = "/controldb",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void setDBMessage(@RequestBody DBMess dbMessage){
        try {
            iInitService.setDBMess(dbMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info(dbMessage.toString());
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Teacher> list=iPersonService.queryTeacherAll();
        model.addAttribute("list",list);
        return "list";
    }
}
