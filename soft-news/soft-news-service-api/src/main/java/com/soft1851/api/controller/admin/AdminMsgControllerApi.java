package com.soft1851.api.controller.admin;

import com.soft1851.pojo.bo.AdminLoginBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：tianzhen
 * @date ：2020/11/20 15:58
 * @description：TODO
 */
@Api(value = "管理员维护",tags = {"管理员维护controller"})
@RequestMapping("adminMsg")
public interface AdminMsgControllerApi {

    @PostMapping("/adminLogin")
    @ApiOperation(value = "管理员登录",notes = "管理员登录",httpMethod = "POST")
    GraceResult adminLogin(@RequestBody AdminLoginBO adminLoginBO,
                           HttpServletRequest request,
                           HttpServletResponse response);

    /**
     * 查询管理员是否存在
     * @param username
     * @return
     */
    @PostMapping("adminIsExist")
    @ApiOperation(value = "查询管理员是否存在",notes = "查询管理员是否存在",httpMethod = "POST")
    GraceResult adminIsExist(@RequestParam String username);

//    /**
//     * 新增管理员
//     * @param request
//     * @param response
//     * @param newAdminBO
//     * @return
//     */
//    @PostMapping("/addNewAdmin")
//    @ApiOperation(value = "添加新的管理人员",notes = "添加新的管理人员",httpMethod = "POST")
//    GraceResult addNewAdmin(HttpServletRequest request, HttpServletResponse response, @RequestBody NewAdminBO newAdminBO);

//    /**
//     * 分页查询
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @PostMapping("/getAdminList")
//    @ApiOperation(value = "查询admin列表",notes = "查询admin列表",httpMethod = "POST")
//
//    GraceResult getAdminList(
//            @ApiParam(name = "page", value = "查询下一页的第几页")
//            @RequestParam Integer page,
//            @ApiParam(name = "pageSize", value = "分页查询每一页的条数")
//            @RequestParam Integer pageSize);
//
//
//    /**
//     * 退出登录
//     *
//     * @param adminId  管理员id
//     * @param request  请求
//     * @param response 响应
//     * @return 返回
//     */
//    @ApiOperation(value = "管理员注销", notes = "管理员注销", httpMethod = "POST")
//    @PostMapping("adminLogout")
//    GraceResult adminLogout(@RequestParam String adminId,
//                            HttpServletRequest request,
//                            HttpServletResponse response);

}