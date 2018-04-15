package com.keeper.springBootHelloWorld;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.keeper.springBootHelloWorld.dao.entity.UserInfo;
import com.keeper.springBootHelloWorld.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Before
    public void setUp() throws Exception {
        String ddl = getClass().getResource("/db/ddl.sql" ).toURI().toString().substring(6);
        String dml = getClass().getResource("/db/dml.sql" ).toURI().toString().substring(6);

        DataSource dataSource = (DataSource) applicationContext.getBean("h2DataSource" );

        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        st.execute( "drop all objects;");// 这一句可以不要

        st.execute( "runscript from '" + ddl + "'");
        st.execute( "runscript from '" + dml + "'" );

        st.close();
        conn.close();
    }

}
