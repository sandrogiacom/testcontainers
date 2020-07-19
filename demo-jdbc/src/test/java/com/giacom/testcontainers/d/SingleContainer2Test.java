package com.giacom.testcontainers.d;

import org.junit.Test;

public class SingleContainer2Test extends AbstractContainerBaseTest {

    @Test
    public void checkContainer() {
        System.out.println(MY_SQL_CONTAINER.getJdbcUrl());
    }

    @Test
    public void checkContainer1() {
        System.out.println(MY_SQL_CONTAINER.getJdbcUrl());
    }

}
