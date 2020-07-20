package com.giacom.tc.demo.config.jdbc.mysql;

import org.testcontainers.containers.MySQLContainer;

import com.giacom.tc.demo.config.jdbc.AbstractDatabaseTest;

public class MySqlDatabaseTest extends AbstractDatabaseTest {

    MySQLContainer mysql;

    public MySqlDatabaseTest() {
        mysql = new MySQLContainer()
                .withConfigurationOverride("mysql_conf_override");
        mysql.start();
        setJdbcDatabaseContainer(mysql);
    }

    @Override
    public String getDriverClassName() {
        return mysql.getDriverClassName();
    }

}
