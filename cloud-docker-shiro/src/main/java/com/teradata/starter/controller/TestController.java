package com.teradata.starter.controller;

import com.teradata.common.util.JWTUtil;
import com.teradata.starter.bean.UserBean;
import com.teradata.starter.repository.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyaohui
 * @date 2018/8/6 0006 上午 10:09
 */

@RestController
public class TestController {


    @Autowired
    private UserService userService;

    /**
     * 需要登录验证
     * @return
     */
    @GetMapping("/test")
    @RequiresAuthentication
    public String test(){
        return "success";
    }


    @RequestMapping("/login")
    public String login(){
        return JWTUtil.sign("idaadmin");
    }

    @GetMapping("/getUser")
    @RequiresRoles("")
    public String testGetUser(){

        String userName= "idaadmin";
        UserBean userBean=userService.getUserByName(userName);
        return userBean.toString();
    }
}
