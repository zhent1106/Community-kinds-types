package com.soft1851.api.controller.article;

import com.soft1851.pojo.bo.NewArticleBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @ClassName ArticleControllerApi
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
@Api(value = "文章业务的controller",tags = {"文章业务的controller"})
@RequestMapping("article")
public interface ArticleControllerApi {
    /**
     * 用户发布文章
     * @param newArticleBO
     * @return
     */
    @PostMapping("/createArticle")
    @ApiOperation(value = "用户发文",notes = "用户发文",httpMethod = "POST")
    GraceResult createArticle(@RequestBody @Valid NewArticleBO newArticleBO,BindingResult result);

    /**
     * 管理员审核文章
     * @param articleId
     * @param passOrNot
     * @return
     */
    @PostMapping("/doReview")
    @ApiOperation(value = "管理员审核文章",notes = "管理员审核文章",httpMethod = "POST")
    GraceResult doReview(@RequestParam String articleId,@RequestParam Integer passOrNot);

    /**
     * 用户删除文章
     * @param articleId
     * @param userId
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation(value = "用户删除文章",notes = "用户删除文章",httpMethod = "POST")
    GraceResult delete(@RequestParam String userId,@RequestParam String articleId);

    /**
     * 用户撤回文章
     * @param userId
     * @param articleId
     * @return
     */
    @PostMapping("/withdraw")
    @ApiOperation(value = "用户撤回文章",notes = "用户撤回文章",httpMethod = "POST")
    GraceResult withdraw(@RequestParam String userId,@RequestParam String articleId);

    /**
     * 查询文章详情
     * @param articleId
     * @return
     */
    @GetMapping("detail")
    @ApiOperation(value = "查询文章详情",notes = "查询文章详情",httpMethod = "GET")
    GraceResult detail(@RequestParam String articleId);

    /**
     * 阅读文章，累加阅读量
     * @param articleId
     * @return
     */
    @PostMapping("detail")
    @ApiOperation(value = "阅读文章，累加阅读量",notes = "阅读文章，累加阅读量",httpMethod = "POST")
    GraceResult readArticle(@RequestParam String articleId,HttpServletRequest request);



}