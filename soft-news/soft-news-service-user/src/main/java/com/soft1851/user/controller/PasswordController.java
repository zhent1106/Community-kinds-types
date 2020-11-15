package com.soft1851.user.controller;

import com.soft1851.api.controller.user.PassportControllerApi;
import com.soft1851.result.GraceResult;
import com.soft1851.utils.SmsUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PasswordController
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/
@RestController
public class PasswordController implements PassportControllerApi {
    @Resource
    private SmsUtil smsUtil;
    @Override
    public GraceResult getGode(String mobile, HttpServletRequest request) {
        //生成随机验证码并且发送验证码
        String random=(int) ((Math.random()*9+1)*100000)+"";
        System.out.println(random);
        smsUtil.sendSms(mobile,random);
        return GraceResult.ok();
    }
}