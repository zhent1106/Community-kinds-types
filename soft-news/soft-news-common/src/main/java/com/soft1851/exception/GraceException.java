package com.soft1851.exception;

import com.soft1851.result.ResponseStatusEnum;

/**
 * @description: 优雅的统一处理异常
 * @author: mqxu
 * @create: 2020-11-15
 **/
public class GraceException {

    public static void display(ResponseStatusEnum responseStatusEnum) {
        throw new MyCustomException(responseStatusEnum);
    }

}
