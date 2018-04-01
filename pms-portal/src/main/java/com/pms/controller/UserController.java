package com.pms.controller;

import com.pms.pojo.PmsUser;
import com.pms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.PmsResult;
import utils.ExceptionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.controller
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 10:21
 *   *
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ResponseBody
    public PmsResult registerUser(PmsUser pmsUser) {
        try {
            PmsResult pmsResult = userService.registerUser(pmsUser);
            return pmsResult;
        }catch (Exception e){
            return PmsResult.build(400, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/user/login")
    @ResponseBody
    public PmsResult login(String username, String password, HttpServletRequest request, HttpServletResponse response, Integer identity) {
        PmsResult pmsResult = userService.login(username, password, request, response,identity);
        return pmsResult;
    }

    @RequestMapping("/user/showLoginPage")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping("/user/query")
    @ResponseBody
    public PmsResult findUserByUsername(String username){
        PmsResult userByUsername = userService.findUserByUsername(username);
        return userByUsername;
    }

    @RequestMapping("/user/postGraduate")
    public String showGraduatePage(){
        return "postGraduate";
    }

    @RequestMapping("/user/supervisor")
    public String showSupervisorPage(){
        return "supervisor";
    }
    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public Object checkDataInfo(@PathVariable String param, @PathVariable Integer type, String callback){
        if (callback==null|| StringUtils.isBlank(callback)) {
            //传入参数非空判断
            if (StringUtils.isBlank(param) || type == null || (type != 1 && type != 2 && type != 3))
                return PmsResult.build(400, "传入参数有空值或者不合法值");
            PmsResult pmsResult= userService.checkDataInfo(param, type);
            return pmsResult;
        }
        else {
            PmsResult result=null;
            MappingJacksonValue mappingJacksonValue=null;
            //传入参数非空判断
            if (StringUtils.isBlank(param) || type == null || (type != 1 && type != 2 && type != 3)) {
                result = PmsResult.build(400, "传入参数有空值或者不合法值");
                mappingJacksonValue=new MappingJacksonValue(result);
                mappingJacksonValue.setJsonpFunction(callback);
                return mappingJacksonValue;
            }
            result=userService.checkDataInfo(param,type);
            mappingJacksonValue=new MappingJacksonValue(result);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
    }
}
