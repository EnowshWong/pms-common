package com.pms.interceptor;

import com.pms.service.UserService;
import com.pms.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.interceptor
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 14:21
 *   *
 **/
public class LoginInterceptor implements HandlerInterceptor {
    private String LOGIN_PAGE_URL="/";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从cookie中去用户信息
            String pmsUser= CookieUtils.getCookieValue(request, "USER_COOKIE");
        //判断用户名是否存在
        //不存在，则跳转到登陆页面，并且把拦截的url传递给登陆页面，返回false
        if (pmsUser==null){
            response.sendRedirect(LOGIN_PAGE_URL);
            return false;
        }
        //如果存在，则放行,并向前端传递username参数在前端显示
        request.setAttribute("user",pmsUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
