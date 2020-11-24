package com.soft1851.article.service;

import com.soft1851.pojo.Category;
import com.soft1851.pojo.bo.NewArticleBO;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
public interface ArticleService {
    /**
     * 发布文章
     * @param newArticleBO
     * @param category
     */
    void createArticle(NewArticleBO newArticleBO, Category category);
}
