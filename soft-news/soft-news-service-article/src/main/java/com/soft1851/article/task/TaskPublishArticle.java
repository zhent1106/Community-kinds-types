package com.soft1851.article.task;

import com.soft1851.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @ClassName
 * @Description 定时发布文章，头部注解的作用
 * 1.标记配置类，使得springboot容器日志扫描到
 * 2.开启定时任务
 * @Author wanghuanle
 * @Date
 **/
@Configuration
@EnableScheduling
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class TaskPublishArticle {
    private final ArticleService articleService;

    @Scheduled(cron = "0/10 * * * * ?")
    private void publishArticle(){
        System.out.println("执行定时任务：" + LocalDateTime.now());
        //调用文章service，把当前时间应该发布的定时文章，状态改为即时
        articleService.updateAppointToPublish();
    }
}
