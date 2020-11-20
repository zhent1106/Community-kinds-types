package com.soft1851.admin.service.impl;

import com.soft1851.admin.mapper.AdminUserMapper;
import com.soft1851.admin.service.AdminUserService;
import com.soft1851.exception.GraceException;
import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.result.ResponseStatusEnum;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author ：tianzhen
 * @date ：2020/11/20 15:50
 * @description：TODO
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserServiceImpl implements AdminUserService {

    public final AdminUserMapper adminUserMapper;
    public final Sid sid;


    @Override
    public AdminUser queryAdminByUsername(String username) {

        Example adminUserExample = new Example(AdminUser.class);
        Example.Criteria adminUserCriteria = adminUserExample.createCriteria();
        adminUserCriteria.andEqualTo("username",username);
        return adminUserMapper.selectOneByExample(adminUserExample);
    }

    /**
     * 新增管理员
     * @param newAdminBO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAdminUser(NewAdminBO newAdminBO) {
        String adminId = sid.nextShort();
        AdminUser adminUser = new AdminUser();
        adminUser.setId(adminId);
        adminUser.setUsername(newAdminBO.getUsername());
        adminUser.setAdminName(newAdminBO.getAdminName());
//        如果密码不为空，则需要加密，存入数据库
        if (StringUtils.isNotBlank(newAdminBO.getPassword())){
            String pwd = BCrypt.hashpw(newAdminBO.getPassword(),BCrypt.gensalt());
            adminUser.setPassword(pwd);
        }
//        如果人脸上传以后，则有faceId，需要和admin信息存储入库
        if (StringUtils.isNotBlank(newAdminBO.getFaceId())){
            adminUser.setFaceId(newAdminBO.getFaceId());
        }
        adminUser.setCreatedTime(new Date());
        adminUser.setUpdatedTime(new Date());
        int result = adminUserMapper.insert(adminUser);
        if (result !=1 ){
            GraceException.display(ResponseStatusEnum.ADMIN_CREATE_ERROR);
        }
    }
//
//    /**
//     * 分页
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @Override
//    public PageGridResult queryAdminList(Integer page, Integer pageSize) {
//        Example adminExample = new Example(AdminUser.class);
//        adminExample.orderBy("createdTime").desc();
//
//        PageHelper.startPage(page,pageSize);
//        List<AdminUser> adminUserList =
//                adminUserMapper.selectByExample(adminExample);
//        return setterPageGrid(adminUserList,page);
//    }
//    private PageGridResult setterPageGrid(List<?> adminUserList, Integer page){
//        PageInfo<?> pageList = new PageInfo<>(adminUserList);
//        PageGridResult gridResult = new PageGridResult();
//        gridResult.setRows(adminUserList);
//        gridResult.setPage(page);
//        gridResult.setRecords(pageList.getPages());
//        gridResult.setTotal(pageList.getTotal());
//        return gridResult;
//    }
}
