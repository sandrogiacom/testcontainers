package com.giacom.testcontainers.e;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class MySQL8Test {

    @ClassRule
    public static MySQLContainer mysql = new MySQLContainer("mysql:8.0");

    @Test
    public void checkContainer() {
        System.out.println(mysql.getJdbcUrl());
    }

    @Test
    public void checkContainer1() {
        System.out.println(mysql.getJdbcUrl());
    }

}
