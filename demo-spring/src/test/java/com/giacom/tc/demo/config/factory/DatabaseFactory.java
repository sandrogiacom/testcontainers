package com.giacom.tc.demo.config.factory;

import com.giacom.tc.demo.config.DataBaseVendor;
import com.giacom.tc.demo.config.exception.InvalidDatabaseVendorException;
import com.giacom.tc.demo.config.jdbc.AbstractDatabaseTest;
import com.giacom.tc.demo.config.jdbc.mysql.MySqlDatabaseTest;
import com.giacom.tc.demo.config.jdbc.oracle.OracleDatabaseTest;
import com.giacom.tc.demo.config.jdbc.postgresql.PostgresDatabaseTest;

public class DatabaseFactory {

    public static AbstractDatabaseTest getDatabase(String dbVendor) throws InvalidDatabaseVendorException {
        DataBaseVendor vendor = DataBaseVendor.of(dbVendor);

        switch (vendor) {
            case MYSQL:
                return new MySqlDatabaseTest();
            case ORACLE:
                return new OracleDatabaseTest();
            case POSTGRESQL:
                return new PostgresDatabaseTest();
            default:
                throw new InvalidDatabaseVendorException(dbVendor + " is not supported!");
        }
    }
}
