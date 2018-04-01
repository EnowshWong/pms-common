package com.pms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.controller
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 9:18
 *   *
 **/
@Controller
public class PageController {

    @RequestMapping("/")
    public String showLoginPage(){
        return "index";
    }

    @RequestMapping("/page/register")
    public String showReigsterPage(){
        return "register";
    }

    @RequestMapping("/page/login")
    public String showStuLoginPage(Integer identity, Model model){
        model.addAttribute("identity",identity);
        return "login";
    }

}
