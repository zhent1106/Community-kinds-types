package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RegionRatioVO
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegionRatioVO {
    private  String name;
    private  Integer value;

}