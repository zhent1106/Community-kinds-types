package com.soft1851.api.interceptors;

import com.soft1851.exception.GraceException;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.utils.IpUtil;
import com.soft1851.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName PassportInterceptor
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/
public class PassportInterceptor implements HandlerInterceptor {
    @Autowired
    public RedisOperator redis;
    public static  final  String MOBILE_SMSCODE="mobile:smscode";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户ip
        String userIp= IpUtil.getRequestIp(request);
        boolean keyIsExist=redis.keyIsExist(MOBILE_SMSCODE+":"+userIp);
        if (keyIsExist){
            GraceException.display(ResponseStatusEnum.SMS_NEED_WAIT_ERROR);
            return false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}