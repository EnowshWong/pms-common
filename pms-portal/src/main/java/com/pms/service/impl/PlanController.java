package com.pms.service.impl;

import com.pms.pojo.PmsPlan;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUIResult;
import pojo.PmsResult;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service.impl
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/11 11:34
 *   *
 **/
@Controller
public class PlanController {
    @Autowired
    private PlanService planService;

    @RequestMapping("/plan/save")
    @ResponseBody
    public PmsResult savePlan(PmsPlan pmsPlan){
        PmsResult pmsResult = planService.savePlan(pmsPlan);
        return pmsResult;
    }

    @RequestMapping("/plan/list")
    @ResponseBody
    public EasyUIResult getPlanList(int page,int row,long stuId){
        EasyUIResult planList = planService.getPlanList(page, row, stuId);
        return planList;
    }

    @RequestMapping("/plan/update")
    @ResponseBody
    public PmsResult updatePlan(PmsPlan pmsPlan){
        PmsResult pmsResult = planService.updatePlan(pmsPlan);
        return pmsResult;
    }

    @RequestMapping("/plan/delete")
    @ResponseBody
    public PmsResult deletePlan(long id){
        PmsResult pmsResult = planService.deletePlan(id);
        return pmsResult;
    }

}
