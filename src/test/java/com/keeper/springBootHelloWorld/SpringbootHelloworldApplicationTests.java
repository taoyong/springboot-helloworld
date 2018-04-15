package com.keeper.springBootHelloWorld;

import com.keeper.springBootHelloWorld.dao.entity.UserInfo;
import com.keeper.springBootHelloWorld.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHelloworldApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        UserInfo userInfo = userService.getById((long)1);
        Assert.assertNotNull(userInfo);
    }

}
