package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AppUserVO
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserVO {
    private  String id;
    private  String  nickname;
    private  String face;
    private  Integer activeStatus;
    private  Integer myFollowCounts;
    private  Integer myFansCounts;

}