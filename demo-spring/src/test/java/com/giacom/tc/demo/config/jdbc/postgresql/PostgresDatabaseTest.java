package com.giacom.tc.demo.config.jdbc.postgresql;

import org.testcontainers.containers.PostgreSQLContainer;

import com.giacom.tc.demo.config.jdbc.AbstractDatabaseTest;

public class PostgresDatabaseTest extends AbstractDatabaseTest {

    PostgreSQLContainer postgresql;

    public PostgresDatabaseTest() {
        postgresql = new PostgreSQLContainer();
        postgresql.start();
        setJdbcDatabaseContainer(postgresql);
    }

    @Override
    public String getDriverClassName() {
        return postgresql.getDriverClassName();
    }

}
