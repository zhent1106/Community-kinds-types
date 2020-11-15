package com.soft1851.api.controller.user;

import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PassportControllerApi
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/
@Api(value = "用户注册登录",tags = {"用户注册登录controller"})
@RequestMapping("password")
public interface PassportControllerApi {
    /**
     * 发送短信
     * @param mobile
     * @param request
     * @return
     */
    @ApiOperation(value = "获取短信验证码",notes = "获取短信验证码",httpMethod = "GET")
    @GetMapping("/smsCode")
    GraceResult getGode(@RequestParam String mobile, HttpServletRequest request);
}
