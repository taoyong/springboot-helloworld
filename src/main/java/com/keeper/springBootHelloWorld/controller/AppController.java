package com.keeper.springBootHelloWorld.controller;


import com.keeper.springBootHelloWorld.dto.ResponseWrapper;
import com.keeper.springBootHelloWorld.dto.UserLoginReq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/helloworld/app/v1")
public class AppController {

    /**
     * local-requrl:http://localhost:8080/helloworld/app/v1/userlogin?userId=333
     * @param userLoginReq
     * @return
     */
    @RequestMapping("/userlogin")
    public ResponseWrapper userLogin(@Valid UserLoginReq userLoginReq){
        log.info("用户登录,userLoginReq={}",userLoginReq);
        return ResponseWrapper.succ();
    }
}

