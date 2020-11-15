package com.soft1851.user.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.controller.user.PassportControllerApi;
import com.soft1851.result.GraceResult;
import com.soft1851.utils.IpUtil;
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
public class PasswordController extends BaseController implements PassportControllerApi {
    @Resource
    private SmsUtil smsUtil;
    @Override
    public GraceResult getGode(String mobile, HttpServletRequest request) {
        //获得用户ip
        String userIp= IpUtil.getRequestIp(request);
        //根据用户ip进行限制，限制用户在60秒内只收到用一个验证码
        redis.setnx60s(MOBILE_SMSCODE+":"+userIp,userIp);
        //生成随机验证码并且发送验证码
        String random=(int) ((Math.random()*9+1)*100000)+"";
        smsUtil.sendSms(mobile,random);
        redis.set(MOBILE_SMSCODE+":"+mobile,random,30*60);
        return GraceResult.ok();
    }
}