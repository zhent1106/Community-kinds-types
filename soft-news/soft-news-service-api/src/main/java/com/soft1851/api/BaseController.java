package com.soft1851.api;

import com.soft1851.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/15
 **/

public class BaseController {
    @Autowired
    public RedisOperator redis;
    public  static final String MOBILE_SMSCODE="mobile:smscode";
}