package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

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

    @Test
    void testAllReportsRunSuccessfully() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try (PrintStream capturedOutput = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setOut(capturedOutput);

            // Run the application against the test database with no startup delay.
            App.main(new String[]{"localhost:33060", "0"});
        } finally {
            System.setOut(originalOutput);
        }

        String reportOutput = output.toString(StandardCharsets.UTF_8);

        assertFalse(reportOutput.contains("MySQL connection or report failed"),
                "The application should run all reports without a database or SQL error");

        for (int reportNumber = 1; reportNumber <= 22; reportNumber++) {
            assertTrue(reportOutput.contains("\n" + reportNumber + "."),
                    "Report " + reportNumber + " should run");
        }
    }
}
