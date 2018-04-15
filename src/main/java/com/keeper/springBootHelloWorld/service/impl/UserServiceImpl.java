package com.keeper.springBootHelloWorld.service.impl;

import com.keeper.springBootHelloWorld.dao.entity.UserInfo;
import com.keeper.springBootHelloWorld.dao.mapper.UserInfoMapper;
import com.keeper.springBootHelloWorld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getById(Long id){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }

}
