package com.giacom.testcontainers.c;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class SingleContainerTest {

    @ClassRule
    public static MySQLContainer mysql = new MySQLContainer();

    @Test
    public void checkContainer() {
        System.out.println(mysql.getJdbcUrl());
    }

    @Test
    public void checkContainer1() {
        System.out.println(mysql.getJdbcUrl());
    }

}
