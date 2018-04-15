package com.keeper.springBootHelloWorld.beanConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Data
//@Component
//@ConfigurationProperties(prefix = "spring.datasource")
public class DbPropertyConfig {

    private String driverClassName;

    private String url;

    private String username;

    private String password;


}
