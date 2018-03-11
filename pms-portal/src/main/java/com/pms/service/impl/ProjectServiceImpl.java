package com.pms.service.impl;

import com.pms.mapper.PmsProjectMapper;
import com.pms.pojo.PmsProject;
import com.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.PmsResult;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service.impl
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 21:56
 *   *
 **/
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private PmsProjectMapper pmsProjectMapper;

    @Override
    public PmsResult saveProject(PmsProject pmsProject) {
        pmsProjectMapper.insert(pmsProject);
        return PmsResult.ok();
    }
}
