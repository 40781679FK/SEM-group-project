package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void testGetCountryCount() throws SQLException {
        int countryCount = app.getCountryCount();

        assertTrue(countryCount > 0, "The database should contain countries");
    }
}