package com.giacom.tc.demo.config.jdbc.oracle;

import org.testcontainers.containers.OracleContainer;

import com.giacom.tc.demo.config.jdbc.AbstractDatabaseTest;

public class OracleDatabaseTest extends AbstractDatabaseTest {

    //private static final String IMAGE_NAME = "wnameless/oracle-xe-11g:latest";
    //private static final String IMAGE_NAME = "pengbai/docker-oracle-xe-11g-r2";
    private static final String IMAGE_NAME = "quillbuilduser/oracle-18-xe";
//    private static final String IMAGE_NAME = "ryangoh/oracle_12c_r1 _xe";
    OracleContainer oracle;

    public OracleDatabaseTest() {
        oracle = new OracleContainer(IMAGE_NAME);
        oracle.start();
        System.out.println(oracle.getUsername());
        System.out.println(oracle.getPassword());
        setJdbcDatabaseContainer(oracle);
    }

    @Override
    public String getDriverClassName() {
        return oracle.getDriverClassName();
    }

}
