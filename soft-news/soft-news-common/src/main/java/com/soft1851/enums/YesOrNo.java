package com.soft1851.enums;

/**
 * @ClassName YesOrNo
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
public enum YesOrNo {
    NO(0,"否"),
    YES(1,"是");
    public final Integer type;
    public final String value;
    YesOrNo (Integer type,String value){
        this.type=type;
        this.value=value;
    }
}
