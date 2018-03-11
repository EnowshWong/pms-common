package com.pms.controller;

import com.pms.pojo.PmsProject;
import com.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.PmsResult;
import utils.ExceptionUtil;

import java.awt.*;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.controller
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 20:31
 *   *
 **/
@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/project/save")
    @ResponseBody
    public PmsResult saveProject(PmsProject pmsProject) {
        try {
            PmsResult pmsResult = projectService.saveProject(pmsProject);
            return pmsResult;
        }catch (Exception e){
            return PmsResult.build(400,ExceptionUtil.getStackTrace(e));
        }
    }
}
