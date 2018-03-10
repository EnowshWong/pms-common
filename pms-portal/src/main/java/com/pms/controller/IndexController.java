package com.pms.controller;

import org.springframework.stereotype.Controller;
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
public class IndexController {

    @RequestMapping("/")
    public String showLoginPage(){
        return "index.html";
    }
}
