package com.soft1851.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloControllerApi
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/13
 **/
public interface HelloControllerApi {
    /**
     * hello接口
     * @return
     */
  @GetMapping("/hello")
    Object hello();
}