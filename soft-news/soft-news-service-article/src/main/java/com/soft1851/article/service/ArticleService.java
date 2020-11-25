package com.soft1851.article.service;

import com.soft1851.pojo.Category;
import com.soft1851.pojo.bo.NewArticleBO;

/**
 * @author xunmi
 */
public interface ArticleService {

    /**
     * 发布文章
     *
     * @param newArticleBO
     * @param category
     */
    void createArticle(NewArticleBO newArticleBO, Category category);

    /**
     * 更新文章状态
     * @param articleId
     * @param pendingStatus
     */
    void updateArticleStatus(String articleId,Integer pendingStatus);

    /**
     * 更新定时发布为及时发布
     */
    void updateAppointToPublish();
}
