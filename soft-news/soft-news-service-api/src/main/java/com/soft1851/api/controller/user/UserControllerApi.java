package com.soft1851.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName UserControllerApi
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/14
 **/
public interface UserControllerApi {

    @GetMapping("/users")
    Object getUser();
}