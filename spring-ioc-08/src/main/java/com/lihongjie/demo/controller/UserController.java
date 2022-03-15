package com.lihongjie.demo.controller;

import com.lihongjie.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void getUser(){
        this.userService.getUser();
    }
}
