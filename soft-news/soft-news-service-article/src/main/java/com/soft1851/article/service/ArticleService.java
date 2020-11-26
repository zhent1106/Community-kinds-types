package com.soft1851.article.service;

import com.soft1851.pojo.Category;
import com.soft1851.pojo.bo.NewArticleBO;
import com.soft1851.pojo.vo.ArticleDetailVO;

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

    /**
     * 删除文章
     * @param userId
     * @param articleId
     */
    void deleteArticle(String userId,String articleId);

    /**
     * 撤回文章
     * @param userId
     * @param articleId
     */
    void  withdrawArticle(String userId,String  articleId);

    /**
     * 查询文章详情
     * @param articleId
     * @return
     */
    ArticleDetailVO queryDetail(String articleId);
}
