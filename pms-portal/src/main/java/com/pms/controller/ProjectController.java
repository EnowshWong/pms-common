package com.pms.controller;

import com.pms.pojo.PageBean;
import com.pms.pojo.PmsProject;
import com.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUIResult;
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

    @RequestMapping("/project/list")
    @ResponseBody
    public EasyUIResult getProjectList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows,long tutorId){
        EasyUIResult easyUIResult = projectService.getProjectList(page, rows, tutorId);
        return easyUIResult;
    }

    @RequestMapping("/project/update")
    @ResponseBody
    public PmsResult updateProject(PmsProject pmsProject){
        try {
            PmsResult pmsResult=projectService.updateProject(pmsProject);
            return pmsResult;
        }catch (Exception e){
            return PmsResult.build(400,ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping("/project/delete")
    @ResponseBody
    public PmsResult deleteProject(long id){
        PmsResult pmsResult = projectService.deleteProject(id);
        return pmsResult;
    }

    @RequestMapping("/project/show")
    public String showProject(@RequestParam(value="currPage",defaultValue="1")int currPage,Model model){
        PageBean<PmsProject> pageBean = projectService.findByPage(currPage);
        model.addAttribute("page",pageBean);
        return "supervisor_proAdmin";
    }

}
