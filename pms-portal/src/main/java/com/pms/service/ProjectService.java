package com.pms.service;

import com.pms.pojo.PmsProject;
import pojo.PmsResult;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 21:56
 *   *
 **/
public interface ProjectService {
    PmsResult saveProject(PmsProject pmsProject);
}
