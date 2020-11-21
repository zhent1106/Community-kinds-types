package com.soft1851.admin.service;

import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.utils.PageGridResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @ClassName AdminUserService
 * @Description TODO
 * @Date 2020/11/20
 * @Version 1.0
 **/
public interface AdminUserService {

    /**
     * 获得管理员用户信息
     *
     * @param username
     * @return
     */
    AdminUser queryAdminByUsername(String username);

    /**
     *增加管理员
     */
    void createAdminUser(NewAdminBO newAdminBO);


    /**
     *
     */
    PageGridResult queryAdminList(Integer page ,Integer pageSize);

    /**
     * 修改制定管理员的faceId
     * @param username
     * @param faceId
     */
    void updateAdmin(String username,String faceId);
}
