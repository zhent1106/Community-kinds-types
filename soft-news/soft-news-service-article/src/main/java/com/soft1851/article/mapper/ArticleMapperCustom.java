package com.soft1851.article.mapper;

import com.soft1851.my.mapper.MyMapper;
import com.soft1851.pojo.Article;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ArticleMapperCustom
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/25
 **/
@Repository
public interface ArticleMapperCustom extends MyMapper<Article> {
    /**
     * 更新文章发布状态。定时——及时发布
     */
    void updateAppointToPublish();

}
