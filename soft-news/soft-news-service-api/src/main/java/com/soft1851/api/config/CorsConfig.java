package com.soft1851.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ClassName CoresConfig
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/
@Configuration
public class CorsConfig {

 public CorsConfig(){

 }
 @Bean
    public CorsFilter corsFilter(){
     //添加cors配置信息
     CorsConfiguration corsConfiguration=new CorsConfiguration();
     corsConfiguration.addAllowedOrigin("*");
     corsConfiguration.setAllowCredentials(true);
     corsConfiguration.addAllowedMethod("*");
     corsConfiguration.addAllowedHeader("*");
     UrlBasedCorsConfigurationSource corsConfigurationSource=new UrlBasedCorsConfigurationSource();
     corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
     return  new CorsFilter(corsConfigurationSource);
 }
}