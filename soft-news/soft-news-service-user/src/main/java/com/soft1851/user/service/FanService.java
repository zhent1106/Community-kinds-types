package com.soft1851.user.service;

import com.soft1851.enums.Sex;
import com.soft1851.pojo.vo.RegionRatioVO;

import java.util.List;

/**
 * @ClassName FanService
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/26
 **/
    public interface FanService {
    /**
     * 查询当前用户是否关注作者
     * @param writerId
     * @param fanId
     * @return
     */
        boolean isMeFollowThisWriter(String writerId,String fanId);

    /**
     * 关注作者，成为粉丝
     * @param writerId
     * @param fanId
     */
        void  follow(String writerId,String fanId);

    /**
     * 取消关注
     * @param writerId
     * @param fanId
     */
    void  unfollow(String writerId,String fanId);

    /**
     * 按性别统计粉丝数
     * @param writerId
     * @param sex
     * @return
     */
    Integer queryFansCounts(String writerId, Sex sex);

    /**
     * 根据地域查询粉丝数量
     * @param writerId
     * @return
     */
    List<RegionRatioVO> queryRegionRatioCounts(String writerId);
    }
