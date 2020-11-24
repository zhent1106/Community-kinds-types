package com.soft1851.pojo.validate;

import com.soft1851.utils.UrlUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName CheckUrlValidate
 * @Description 校验链接注解
 * @Author 田震
 * @Date 2020/11/24
 **/
public class CheckUrlValidate implements ConstraintValidator<com.soft1851.pojo.validate.CheckUrl,String> {
    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        return UrlUtil.verifyUrl(url.trim());
    }
}