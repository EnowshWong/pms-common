package com.pms.service;

import com.pms.pojo.PmsUser;
import pojo.PmsResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 10:29
 *   *
 **/
public interface UserService {
    PmsResult registerUser(PmsUser pmsUser);
    PmsResult login(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
