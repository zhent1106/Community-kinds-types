package com.soft1851.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @ClassName Category
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
public class Category {
    @Id
    private  Integer id;
    private  String name;
    @Column(name = "tag_color")
    private String tagColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }
}