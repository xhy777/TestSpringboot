package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entities.UserBean;
import com.example.service.UserService;
import com.example.utils.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    public final UserService userService;
    @RequestMapping("/getAdminById")
    public RestResponse<UserBean> getAdminById(){
        UserBean userBean = userService.getById(1);
        if(userBean == null){
            return RestResponse.fail("没有数据");
        }else {
            return RestResponse.ok(userBean);
        }
    }
    @RequestMapping("/getAdminByName")
    public RestResponse<UserBean> getAdminByName(String username,String password){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uname",username);
        queryWrapper.eq("upassword",password);
        UserBean userBean = userService.getOne(queryWrapper);
        if (userBean!=null){
            return RestResponse.ok(userBean);
        }else {
            return RestResponse.fail("用户名或密码错误!!");
        }
    }
}
