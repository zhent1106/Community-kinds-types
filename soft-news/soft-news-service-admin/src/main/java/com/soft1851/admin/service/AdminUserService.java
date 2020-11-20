package com.soft1851.admin.service;

import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.NewAdminBO;

/**
 * @author ：tianzhen
 * @date ：2020/11/20 15:47
 * @description：TODO
 */
public interface AdminUserService {


    /**
     * 获得管理员信息
     * @param username 用户名
     * @return AdminUser
     */

    AdminUser queryAdminByUsername(String username);

    /**
     * 新增管理员
     * @param newAdminBO
     */
    void createAdminUser(NewAdminBO newAdminBO);
//
//    /**
//     * 分页
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    PageGridResult queryAdminList(Integer page, Integer pageSize);
}
