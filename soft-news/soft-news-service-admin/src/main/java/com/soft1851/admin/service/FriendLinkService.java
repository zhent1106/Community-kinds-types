package com.soft1851.admin.service;

import com.soft1851.pojo.mo.FriendLinkMO;

import java.util.List;

/**
 * @ClassName FriendLinkService
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/

public interface FriendLinkService {

    void saveOrUpdateFriendLink(FriendLinkMO friendLinkMO);

    /**
     * 查询友情链接
     * @return
     */

    List<FriendLinkMO> queryAllFriendLinkList();

    /**
     * 删除友情链接
     * @param linkId
     */
    void delete(String linkId);
}
