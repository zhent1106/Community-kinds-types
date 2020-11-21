package com.soft1851.admin.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @ClassName MD5Controller
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/21
 **/
public class MD5Controller {
    public static void main(String[] args) {
        String pwd = BCrypt.hashpw("123123", BCrypt.gensalt());
        System.out.println(pwd);
    }
}