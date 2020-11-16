package com.soft1851.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RegisLoginBO
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistLoginBO {
    /**
     * @Notnull只检验null值，notblank同时检测null和“”串
     */
    @NotBlank(message = "手机号不能为空")
    private String mobile;
    @NotBlank(message = "短信验证码不能为空")
    private String smsCode;
}