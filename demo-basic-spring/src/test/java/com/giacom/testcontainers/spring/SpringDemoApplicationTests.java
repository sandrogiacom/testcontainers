package com.giacom.testcontainers.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "setup_database.sql")
public class SpringDemoApplicationTests {

    @Autowired
    DataSource ds;

    @Test
    public void peopleFindTest() throws SQLException {
        System.out.println("\n@@@@@@ inside test @@@@@: " + ds.getConnection().getMetaData().getURL());
        System.out.println();

        try (Connection con = ds.getConnection()) {
            try (Statement statement = con.createStatement()) {
                ResultSet rs = statement.executeQuery("SELECT * from person");
                while (rs.next()){
                    System.out.print("id: = " + rs.getString("id"));
                    System.out.print(", first_name = " + rs.getString("first_name"));
                    System.out.print(", last_name = " + rs.getString("last_name"));
                }
            }
        }
    }

}
