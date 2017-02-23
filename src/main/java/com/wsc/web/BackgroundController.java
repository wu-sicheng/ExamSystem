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
    @RequestMapping(value = "/admin/powerManager",method = RequestMethod.GET)
    public String powerManager(){
        return "/background/admin/powerManager";
    }
}
