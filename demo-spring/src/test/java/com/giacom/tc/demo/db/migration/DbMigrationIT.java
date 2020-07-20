package com.giacom.tc.demo.db.migration;


import static com.giacom.tc.demo.db.migration.DatabaseMetadata.getColumns;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.giacom.tc.demo.config.exception.InvalidDatabaseVendorException;
import com.giacom.tc.demo.config.factory.DatabaseFactory;
import com.giacom.tc.demo.config.jdbc.AbstractDatabaseTest;

@RunWith(Parameterized.class)
public class DbMigrationIT {

    AbstractDatabaseTest dbTest;

    @Parameter
    public static String dbVendor;

    @Parameters(name = "{0}")
    public static List<String> params() {
        //return Arrays.asList("mysql", "oracle", "postgresql");
        return Arrays.asList("mysql", "postgresql");
    }

    @Before
    public void initDatabase() throws InvalidDatabaseVendorException {
        dbTest = DatabaseFactory.getDatabase(dbVendor);
    }

    @Test
    public void createSampleUserTable() throws SQLException {
        ClassicConfiguration configuration = new ClassicConfiguration();
        configuration.setLocations(new Location("db/migration/" + dbVendor));
        configuration.setDataSource(dbTest.getJdbcUrl(), dbTest.getUsername(), dbTest.getPassword());
        configuration.setBaselineOnMigrate(true);
        configuration.setBaselineVersionAsString("0");
        Flyway flyway = new Flyway(configuration);
        flyway.migrate();

        List<String> columnNames = getColumns(flyway, dbVendor, "SAMPLE_USER");
        assertThat(columnNames)
                .hasSize(4)
                .containsExactlyInAnyOrder("ID", "NAME", "LAST_NAME", "AGE");
    }

}
