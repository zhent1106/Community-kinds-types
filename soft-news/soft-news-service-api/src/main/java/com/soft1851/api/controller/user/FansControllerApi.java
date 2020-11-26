package com.soft1851.api.controller.user;

import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName FansControllerApi
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/26
 **/
@Api(value = "粉丝管理",tags = {"粉丝管理"})
@RequestMapping("fans")
public interface FansControllerApi {
    /**
     *查询当前用户是否关注作者
     * @param writerId
     * @param fanId
     * @return
     */
    @ApiOperation(value = "查询当前用户是否关注作者", notes = "查询当前用户是否关注作者", httpMethod = "POST")
    @PostMapping("/isMeFollowThisWriter")
    GraceResult isMeFollowThisWriter(@RequestParam String writerId,@RequestParam String  fanId);

    /**
     * 关注作者，成为粉丝
     * @param writerId
     * @param fanId
     * @return
     */
    @ApiOperation(value = "关注作者，成为粉丝", notes = "查询当前用户是否关注作者", httpMethod = "POST")
    @PostMapping("/follow")
    GraceResult follow(@RequestParam String writerId,@RequestParam String  fanId);

    /**
     * 取消关注
     * @param writerId
     * @param fanId
     * @return
     */
    @ApiOperation(value = "取消关注", notes = "取消关注", httpMethod = "POST")
    @PostMapping("/unfollow")
    GraceResult unfollow(@RequestParam String writerId,@RequestParam String  fanId);

    /**
     * 根据性别查询粉丝数量
     * @param writerId
     * @return
     */
    @ApiOperation(value = "根据性别查询粉丝数量", notes = "根据性别查询粉丝数量", httpMethod = "POST")
    @PostMapping("/queryRatio")
    GraceResult queryRatio(@RequestParam String writerId);

    /**
     * 根据地域查询粉丝数量
     * @param writerId
     * @return
     */
    @ApiOperation(value = "根据地域查询粉丝数量", notes = "根据地域查询粉丝数量", httpMethod = "POST")
    @PostMapping("/queryRatioByRegion")
    GraceResult queryRatioByRegion(@RequestParam String writerId);
}
