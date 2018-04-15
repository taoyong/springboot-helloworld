package com.keeper.springBootHelloWorld.service;

import com.keeper.springBootHelloWorld.dao.entity.UserInfo;

public interface UserService {


    UserInfo getById(Long id);
}
