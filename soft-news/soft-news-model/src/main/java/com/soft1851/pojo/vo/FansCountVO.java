package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName FansCountVO
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FansCountVO {
    private  Integer manCounts;
    private  Integer womanCounts;


}