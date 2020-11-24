package com.soft1851.admin.repository;

import com.soft1851.pojo.mo.FriendLinkMO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ClassName FriendLinkRepository
 * @Description 友情操作
 * @Author 田震
 * @Date 2020/11/24
 **/
public interface FriendLinkRepository extends MongoRepository<FriendLinkMO,String> {
    /**
     * 根据是否删除字段查询所有的友链
     * @param isDelete
     * @return
     */
    List<FriendLinkMO> getAllByIsDelete(Integer isDelete);
}