package com.pms.service;

import com.pms.pojo.PmsPlan;
import pojo.EasyUIResult;
import pojo.PmsResult;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/11 11:26
 *   *
 **/
public interface PlanService {
    PmsResult savePlan(PmsPlan pmsPlan);
    EasyUIResult getPlanList(int page,int row,long stuId);
    PmsResult updatePlan(PmsPlan pmsPlan);
    PmsResult deletePlan(long id);
}
