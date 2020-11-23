package com.soft1851.admin.controller;

import com.soft1851.admin.service.AdminUserService;
import com.soft1851.api.BaseController;
import com.soft1851.api.controller.admin.AdminMsgControllerApi;
import com.soft1851.enums.FaceVerifyType;
import com.soft1851.exception.GraceException;
import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.AdminLoginBO;
import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.utils.FaceVerifyUtil;
import com.soft1851.utils.PageGridResult;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author
 * @ClassName AdminMsgController
 * @Description TODO
 * @Date 2020/11/20
 * @Version 1.0
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminMsgController extends BaseController implements AdminMsgControllerApi {
    private final AdminUserService adminUserService;
    private  final FaceVerifyUtil faceVerifyUtil;
    private final RestTemplate restTemplate;

    @Override
    public GraceResult adminLogin(AdminLoginBO adminLoginBO, HttpServletRequest request, HttpServletResponse response) {
        // 查看用户是否存在
        AdminUser adminUser = adminUserService.queryAdminByUsername(adminLoginBO.getUsername());
        if (adminUser == null) {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_NOT_EXIT_ERROR);
        }
        // 判断密码是否匹配
        boolean isPwdMath = BCrypt.checkpw(adminLoginBO.getPassword(), adminUser.getPassword());
        if (isPwdMath) {
            doLoginSettings(adminUser, request, response);
            return GraceResult.ok();
        } else {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_NOT_EXIT_ERROR);
        }
    }

    @Override
    public GraceResult adminIsExist(String username) {
        checkAdminExist(username);
        return GraceResult.ok();
    }

    @Override
    public GraceResult addNewAdmin(HttpServletRequest request, HttpServletResponse response, NewAdminBO newAdminBO) {
        // 1. base64 不为空，则代表人脸入库，否则需要用户输入密码和确认密码
        if (StringUtils.isBlank(newAdminBO.getImg64())) {
            if (StringUtils.isBlank(newAdminBO.getPassword()) ||
                    StringUtils.isBlank(newAdminBO.getConfirmPassword())
            ) {
                return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_PASSWORD_NULL_ERROR);
            }
        }
        // 2. 密码不为空，则必须判断两次输入一致
        if (StringUtils.isNotBlank(newAdminBO.getPassword())) {
            if (!newAdminBO.getPassword()
                    .equalsIgnoreCase(newAdminBO.getConfirmPassword())){
                return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_CREATE_ERROR);
            }
        }
        // 3. 校验用户名唯一
        checkAdminExist(newAdminBO.getUsername());
        // 4. 调用 service 存入 admin 信息
        adminUserService.createAdminUser(newAdminBO);
        return GraceResult.ok();
    }

    @Override
    public GraceResult getAdminList(Integer page, Integer pageSize) {
      if (page == null){
          page = COMMON_START_PAGE;
      }
      if (pageSize == null){
          pageSize = COMMON_PAGE_SIZE;
      }
        PageGridResult result = adminUserService.queryAdminList(page,pageSize);
        return GraceResult.ok(result);
    }

    @Override
    public GraceResult adminLogout(String adminId, HttpServletRequest request, HttpServletResponse response) {
        redis.del(REDIS_ADMIN_TOKEN+":"+adminId);
        deleteCookie(request,response,"aToken");
        deleteCookie(request,response,"aId");
        deleteCookie(request,response,"aName");
        return GraceResult.ok();
    }

    /**
     * 修改管理员信息
     * @param request
     * @param response
     * @param newAdminBO
     * @return
     */
    @Override
    public GraceResult updateAdmin(HttpServletRequest request, HttpServletResponse response, NewAdminBO newAdminBO) {
        adminUserService.updateAdmin(newAdminBO.getUsername(),newAdminBO.getFaceId());

        return GraceResult.ok(newAdminBO);
    }

    @Override
    public GraceResult adminFaceLogin(HttpServletRequest request, HttpServletResponse response, AdminLoginBO adminLoginBO) {
        // 0 判断用户名和人脸信心不能为空
        if (StringUtils.isBlank(adminLoginBO.getUsername())) {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_USERNAME_NULL_ERROR);
        }
        String tempFace64 = adminLoginBO.getImg64();
        if (StringUtils.isBlank(tempFace64)) {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_FACE_NULL_ERROR);
        }
//1 从数据库中根据username查询住faceId
        AdminUser admin = adminUserService.queryAdminByUsername(adminLoginBO.getUsername());
        String adminFaceId = admin.getFaceId();
        if (StringUtils.isBlank(adminFaceId)) {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_FACE_LOGIN_ERROR);
        }
//2 请求文件服务，根据faceId获得人脸数据的base64数据
        String fileServerUrl = "http://localhost:8004/fs/readFace64?faceId=" + adminFaceId;
// 得到的结果是封装的对象，注意一下
        ResponseEntity<GraceResult> responseEntity = restTemplate.getForEntity(fileServerUrl,GraceResult.class);
        GraceResult bodyResult = responseEntity.getBody();
        assert bodyResult != null;
        String base64 = (String) bodyResult.getData();
// 3 调用阿里api进行人脸对比识别，判断可信度，从而实现人脸登录
        boolean result = faceVerifyUtil.faceVerify(FaceVerifyType.BASE64.type,tempFace64,base64,60);
        if (!result) {
            return GraceResult.errorCustom(ResponseStatusEnum.ADMIN_FACE_LOGIN_ERROR);
        }
//4 admin登陆后的数据设置，redis与cookie
        doLoginSettings(admin,request,response);
        return GraceResult.ok();
    }

    private void checkAdminExist(String username) {
        AdminUser admin = adminUserService.queryAdminByUsername(username);
        if (admin != null) {
            GraceException.display(ResponseStatusEnum.ADMIN_USERNAME_EXIST_ERROR);
        }
    }


    private void doLoginSettings(AdminUser admin, HttpServletRequest request, HttpServletResponse response) {
        // 保存token存入redis中
        String token = UUID.randomUUID().toString();
        redis.set(REDIS_ADMIN_TOKEN + ":" + admin.getId(), token);
        // 保存admin登录基本token信息到cookie
        setCookie(request, response, "aToken", token, COOKIE_MONTH);
        setCookie(request, response, "aId", admin.getId(), COOKIE_MONTH);
        setCookie(request, response, "aName", admin.getAdminName(), COOKIE_MONTH);
    }

    public static void main(String[] args) {
        String pwd = BCrypt.hashpw("123123", BCrypt.gensalt());
        System.out.println(pwd);
    }

}
