package com.soft1851.user.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.controller.user.UserControllerApi;
import com.soft1851.pojo.AppUser;
import com.soft1851.pojo.bo.UpdateUserInfoBO;
import com.soft1851.pojo.vo.AppUserVO;
import com.soft1851.pojo.vo.UserAccountInfoVO;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.user.service.UserService;
import com.soft1851.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/14
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController extends BaseController implements UserControllerApi {
private final UserService userService;



    @Override
    public GraceResult getUserInfo(String userId) {
        if (StringUtils.isBlank(userId)){
            return  GraceResult.errorCustom(ResponseStatusEnum.UN_LOGIN);
        }
        //根据Userid查询用户调用内部封装方法
        AppUser user=getUser(userId);
        UserAccountInfoVO accountInfoVO=new UserAccountInfoVO();
        BeanUtils.copyProperties(user,accountInfoVO);
        return GraceResult.ok(accountInfoVO);

    }

    private AppUser getUser(String userId){
       String userJson =redis.get(REDIS_USER_INFO+":"+userId);
            AppUser user;
         if (StringUtils.isNotBlank(userJson)){
             user= JsonUtil.jsonToPojo(userJson,AppUser.class);
         }else {
          user=userService.getUser(userId);
          redis.set(REDIS_USER_INFO+":"+userId,JsonUtil.objectToJson(user),1);
         }
        return user;
    }

    @Override
    public GraceResult updateUserInfo(@Valid UpdateUserInfoBO updateUserInfoBO, BindingResult result) {
        if (result.hasErrors()){
            Map<String,String> errorMap = getErrors(result);
            return GraceResult.errorMap(errorMap);
        }
        userService.updateUserInfo(updateUserInfoBO);
        return GraceResult.ok();
    }

    @Override
    public GraceResult getUserBasicInfo(String userId) {
        if (StringUtils.isBlank(userId)){
            return  GraceResult.errorCustom(ResponseStatusEnum.UN_LOGIN);
        }
        AppUser user=getUser(userId);
        AppUserVO userVO=new AppUserVO();
        BeanUtils.copyProperties(user,userVO);
        return GraceResult.ok(userVO);
    }
}