package com.soft1851.api.controller.category;

import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CategoryControllerApi
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
@Api(value = "文章类型的controller",tags = {"文章业务的controller"})
@RequestMapping("category")
public interface CategoryControllerApi {
    /**
     * 查询文章分类
     * @return
     */
    @GetMapping("/getAll")
    @ApiOperation(value = "查询文章类型",notes = "查询文章类型",httpMethod = "GET")
    GraceResult getAll();
}