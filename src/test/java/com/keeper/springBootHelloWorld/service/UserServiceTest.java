package com.keeper.springBootHelloWorld.service;

import com.alibaba.fastjson.JSONObject;
import com.keeper.springBootHelloWorld.BaseTest;
import com.keeper.springBootHelloWorld.dao.entity.UserInfo;
import com.keeper.springBootHelloWorld.dao.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testGet() {
        UserInfo userInfo = userService.getById((long)1);
        log.info("userInfo={}",JSONObject.toJSONString(userInfo));
        Assert.assertNotNull(userInfo);
    }

    @Test
    public void testInsert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAge((byte) 11);
        userInfo.setUserName("h2-test");

        userInfoMapper.insert(userInfo);

        UserInfo userSelect = userService.getById((long)3);

        log.info("userSelect={}",JSONObject.toJSONString(userSelect));
        Assert.assertTrue(userSelect.getUserAge() == 11);
    }
}
