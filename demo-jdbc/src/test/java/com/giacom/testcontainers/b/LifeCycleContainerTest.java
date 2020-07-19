package com.giacom.testcontainers.b;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class LifeCycleContainerTest {

    private MySQLContainer mysql = new MySQLContainer();

    @Before
    public void before() {
        mysql.start();
    }

    @After
    public void after() {
        mysql.stop();
    }

    @Test
    public void checkContainer() {
        System.out.println(mysql.getJdbcUrl());
    }

    @Test
    public void checkContainer1() {
        System.out.println(mysql.getJdbcUrl());
    }

}
