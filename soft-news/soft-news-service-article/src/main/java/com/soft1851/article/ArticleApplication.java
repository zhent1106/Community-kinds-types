package com.soft1851.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ArticleApplication
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.article.mapper")
@ComponentScan(basePackages = {"com.soft1851", "org.n3r.idworker"})
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }
}