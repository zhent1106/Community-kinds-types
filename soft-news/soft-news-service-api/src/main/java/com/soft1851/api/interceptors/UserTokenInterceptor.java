package com.soft1851.api.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserTokenInterceptor
 * @Description 用户登录拦截器
 * @Author 田震
 * @Date 2020/11/17
 **/
public class UserTokenInterceptor extends BaseInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId=request.getHeader("headerUserId");
        String userToken =request.getHeader("headerUserToken");
        return verifyUserIdToken(userId,userToken,REDIS_USER_TOKEN);
    }


}