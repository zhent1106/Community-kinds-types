package com.soft1851.user.controller;

import com.soft1851.api.controller.user.HelloControllerApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/13
 **/
@RestController
public class HelloController implements HelloControllerApi {


    @Override
    public Object hello() {
        return "hello new soft-news";
    }
}