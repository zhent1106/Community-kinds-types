package com.soft1851.api.config;

import com.soft1851.api.interceptors.PassportInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public PassportInterceptor passportInterceptor(){
        return  new PassportInterceptor();
    }
    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        //注册拦截器，添加拦截器
        registry.addInterceptor(passportInterceptor())
                .addPathPatterns("/passport/smsCode");
    }
}