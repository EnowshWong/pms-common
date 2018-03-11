package com.pms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.mapper.PmsPlanMapper;
import com.pms.pojo.PmsPlan;
import com.pms.pojo.PmsPlanExample;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUIResult;
import pojo.PmsResult;

import java.util.List;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service.impl
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/11 11:27
 *   *
 **/
@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PmsPlanMapper pmsPlanMapper;
    @Override
    public PmsResult savePlan(PmsPlan pmsPlan) {
        pmsPlanMapper.insert(pmsPlan);
        return PmsResult.ok();
    }

    @Override
    public EasyUIResult getPlanList(int page, int row, long stuId) {
        PmsPlanExample example=new PmsPlanExample();
        PmsPlanExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        List<PmsPlan> pmsPlans = pmsPlanMapper.selectByExampleWithBLOBs(example);
        PageHelper.startPage(page,row);
        PageInfo<PmsPlan> pageInfo=new PageInfo<PmsPlan>(pmsPlans);
        long total=pageInfo.getTotal();
        EasyUIResult easyUIResult=new EasyUIResult(total,pmsPlans);
        return easyUIResult;
    }

    @Override
    public PmsResult deletePlan(long id) {
        pmsPlanMapper.deleteByPrimaryKey(id);
        return PmsResult.ok();
    }

    @Override
    public PmsResult updatePlan(PmsPlan pmsPlan) {
        pmsPlanMapper.updateByPrimaryKeySelective(pmsPlan);
        return PmsResult.ok();
    }
}
