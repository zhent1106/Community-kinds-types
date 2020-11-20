package com.soft1851.api.interceptors;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;

/**
 * @author ：zhent
 * @date ：2020/11/20 17:33
 * @description：TODO
 */
public class AdminTokenInterceptor extends BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle) throws Exception{
        String adminUserId = request.getHeader("adminUserId");
        String adminUserToken = request.getHeader("adminUserToken");
        System.out.println("=================================");
        System.out.println("AdminTokenInterceptor - adminUserId =" + adminUserId);
        System.out.println("AdminTokenInterceptor - adminUserToken =" + adminUserToken);
        System.out.println("==================================");
        return verifyUserIdToken(adminUserId,adminUserToken,REDIS_ADMIN_TOKEN);
    }

    @Override
    public void postHandle(HttpServletResponse response, HttpServletRequest request,
                           Object handler, ModelAndView modelAndView) throws Exception{

    }
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
    Object Handler,Exception e) throws Exception{

    }
}
