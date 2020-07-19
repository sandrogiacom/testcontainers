package com.giacom.testcontainers.a;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testcontainers.containers.MySQLContainer;

public class HelloContainerTest {

    @Rule
    public MySQLContainer mysql = new MySQLContainer();

    @Test
    public void checkContainer() {
        System.out.println(mysql.getJdbcUrl());
        Assertions.assertEquals(mysql.isRunning(), true);
    }

    @Test
    public void checkContainer1() {
        System.out.println(mysql.getJdbcUrl());
    }
}
