package com.soft1851.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ：tianzhen
 * @date ：2020/11/20 15:26
 * @description：TODO
 */
@SpringBootApplication
//扫描本项目mapper
@MapperScan(basePackages = "com.soft1851.admin.mapper")
//统一返回结构
@ComponentScan("com.soft1851")
@ComponentScan("org.n3r.idworker")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
