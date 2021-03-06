package com.teradata.zuul.controller;

import com.teradata.zuul.feign.TestFeign;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/testFeign")
    public String testFeign(){
        System.out.println("testFeign success!成功");
        return testFeign.getLoginToken();
    }


//    @GetMapping("/401")
//    public ResponseBean handler401(){
//        return new ResponseBean(401, "Unauthorized", null);
//    }
//
//    @GetMapping("/500")
//    public ResponseBean handler500(){
//        return new ResponseBean(500, "内部错误", null);
//    }
//
//    @RequestMapping("/login")
//    public String test(){
//        return JWTUtil.sign("idaadmin", "dn1rjz8Hzuo=");
//    }
//
//    @GetMapping("/getUser")
//    //@RequiresAuthentication
//    public String testGetUser(){
//
//        String userName= "idaadmin";
//        UserBean userBean=userService.getUserByName(userName);
//        return userBean.toString();
//    }

    @GetMapping("/testRole")
    @RequiresRoles("1")
    public String testRole(){
        return "success";
    }

    @GetMapping("/testPer")
    @RequiresPermissions(logical = Logical.AND, value = {"insert", "get"})
    public String testPermissions(){
        return "success";
    }
}
