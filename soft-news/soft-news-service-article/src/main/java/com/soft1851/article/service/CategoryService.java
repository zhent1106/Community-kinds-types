package com.soft1851.article.service;

import com.soft1851.pojo.Category;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
public interface CategoryService {
    /**
     * 查询所有文章分类
     * @return
     */
    List<Category> selectAll();
}
