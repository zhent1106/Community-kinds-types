package com.soft1851.enums;

/**
 * @ClassName ArticleAppointType
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
public enum ArticleAppointType {
    TIMING(1,"文章定时发布 - 定时"),
    IMMEDIATELY(2,"文章立即发布 - 即时 ");
    public final Integer type;
    public final String value;
    ArticleAppointType (Integer type,String value){
        this.type=type;
        this.value=value;
    }
}
