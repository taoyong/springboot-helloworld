package com.keeper.springBootHelloWorld.controller;


import com.keeper.springBootHelloWorld.dao.entity.UserInfo;
import com.keeper.springBootHelloWorld.dto.ResponseWrapper;
import com.keeper.springBootHelloWorld.dto.UserLoginReq;

import com.keeper.springBootHelloWorld.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/helloworld/app/v1")
public class AppController {

    @Autowired
    private UserService userService;
    /**
     * local-requrl:http://localhost:8080/helloworld/app/v1/userlogin?userId=333
     * @param userLoginReq
     * @return
     */
    @RequestMapping("/userlogin")
    public ResponseWrapper userLogin(@Valid UserLoginReq userLoginReq){
        log.info("用户登录,userLoginReq={}",userLoginReq);
        UserInfo userInfo = userService.getById(Long.valueOf(userLoginReq.getUserId()));
        return userInfo != null ? ResponseWrapper.succ(userInfo) : ResponseWrapper.fail("用户不存在");
    }
}

