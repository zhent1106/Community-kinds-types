package com.soft1851.api;

import com.soft1851.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/

public class BaseController {
    @Autowired
    private RedisOperator redis;


    public static final String MOBILE_SMSCODE = "mobile:smsCode";
    public static final String REDIS_USER_TOKEN = "redis_user_token";
    public static final String REDIS_USER_INFO = "redis_user_info";

    public static final Integer COOKIE_MONTH = 30 * 24 * 60 * 60;
    @Value("${website.domain-name}")
    public String DOMAIN_NAME;

    /**
     * 获取BO中的错误信息，可以通过统一的异常处理返回给客户端
     */
    public Map<String, String> getErrors(BindingResult result){
        Map<String,String> map = new HashMap<>(16);
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList){
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field,msg);
        }
        return map;
    }
    /**
     * 设置cookie
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param maxAge
     */
    public void setCookie(HttpServletRequest request,
                          HttpServletResponse response,
                          String cookieName,
                          String cookieValue,
                          Integer maxAge){
        try {
            cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            setCookieValue(request,response,cookieName,cookieValue,maxAge);
            Cookie cookie = new Cookie(cookieName,cookieValue);
            cookie.setMaxAge(maxAge);
            cookie.setDomain(DOMAIN_NAME);
            cookie.setPath("/");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    private void setCookieValue(HttpServletRequest request,
                                HttpServletResponse response,
                                String cookieName,
                                String cookieValue,
                                Integer maxAge) {

        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(DOMAIN_NAME);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}