package com.soft1851.user.service.impl;

import com.soft1851.api.service.BaseService;
import com.soft1851.pojo.AppUser;
import com.soft1851.pojo.Fans;
import com.soft1851.user.mapper.FansMapper;
import com.soft1851.user.service.FanService;
import com.soft1851.user.service.UserService;
import com.soft1851.utils.RedisOperator;
import lombok.RequiredArgsConstructor;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName FanServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/26
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FanServiceImpl extends BaseService implements FanService {
    private final FansMapper fansMapper;
    private  final Sid sid;
    private final UserService userService;
    private  final RedisOperator redis;

    @Override
    public boolean isMeFollowThisWriter(String writerId, String fanId) {
        Fans fans=new Fans();
        fans.setFanId(fanId);
        fans.setWriterId(writerId);
        int count =fansMapper.selectCount(fans);
        return count>0;
    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void follow(String writerId, String fanId) {
        AppUser fanInfo=userService.getUser(fanId);
         String fanPKId=sid.nextShort();
         Fans fans=new Fans();
         fans.setId(fanPKId);
         fans.setFanId(fanId);
         fans.setFace(fanInfo.getFace());
         fans.setWriterId(writerId);
         fans.setFanNickname(fanInfo.getNickname());
         fans.setProvince(fanInfo.getProvince());
         fans.setSex(fanInfo.getSex());
         fansMapper.insert(fans);
         redis.increment(REDIS_WRITER_FANS_COUNTS+":"+writerId,1);
         redis.increment(REDIS_MY_FOLLOW_COUNTS+":"+fanId,1);
    }

    @Override
    public void unfollow(String writerId, String fanId) {
        Fans fans=new Fans();
        fans.setFanId(fanId);
        fans.setWriterId(writerId);
       fansMapper.delete(fans);
        redis.decrement(REDIS_WRITER_FANS_COUNTS+":"+writerId,1);
        redis.decrement(REDIS_MY_FOLLOW_COUNTS+":"+fanId,1);

    }
}