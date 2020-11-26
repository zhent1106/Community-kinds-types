package com.soft1851.api.interceptors;

import com.soft1851.utils.IpUtil;
import com.soft1851.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ArticleReadInterceptor
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/26
 **/
public class ArticleReadInterceptor extends BaseInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisOperator redis;
    public static final String REDIS_ALREADY_READ = "redis_already_read";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String articleId = request.getHeader("articleId");
        String userIp= IpUtil.getRequestIp(request);
        boolean isExist=redis.keyIsExist(REDIS_ALREADY_READ+":"+articleId+":"+userIp);
        return !isExist;
    }
    @Override
    public void postHandle(HttpServletResponse response, HttpServletRequest request, Object handler, ModelAndView modelAndView) throws Exception {

    }

}