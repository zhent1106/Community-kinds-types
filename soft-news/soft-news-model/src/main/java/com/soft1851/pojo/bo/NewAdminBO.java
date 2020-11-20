package com.soft1851.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengliang
 * @date ：2020/11/20 18:41
 * @description：TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewAdminBO {
    private String username;
    private String adminName;
    private String password;
    private String confirmPassword;
    private String img64;
    private String faceId;
}
