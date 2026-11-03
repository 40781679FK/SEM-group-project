
package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTest {

    // Lab 06 assertion tests

    @Test
    void unitTest() {
        assertEquals(5, 5);
    }

    @Test
    void unitTest3() {
        assertEquals(5, 5, "Messages are equal");
    }

    @Test
    void unitTest4() {
        assertEquals(5.0, 5.01, 0.02);
    }

    @Test
    void unitTest5() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        assertArrayEquals(a, b);
    }

    @Test
    void unitTest6() {
        assertTrue(5 == 5);
    }

    @Test
    void unitTest7() {
        assertFalse(5 == 4);
    }

    @Test
    void unitTest8() {
        assertNull(null);
    }

    @Test
    void unitTest9() {
        assertNotNull("Hello");
    }

    @Test
    void unitTest10() {
        assertThrows(NullPointerException.class, this::throwsException);
    }

    void throwsException() throws NullPointerException {
        throw new NullPointerException();
    }

    // Application-specific unit tests

    @Test
    void testFormatCountry() {
        App app = new App();

        String result = app.formatCountry(
                "GBR", "United Kingdom", "Europe",
                "British Islands", 67215293, "London"
        );

        assertEquals(
                "GBR | United Kingdom | Europe | British Islands | 67215293 | London",
                result
        );
    }

    @Test
    void testFormatCountryWithZeroPopulation() {
        App app = new App();

        String result = app.formatCountry(
                "TST", "Test Country", "Asia",
                "Test Region", 0, "Test Capital"
        );

        assertEquals(
                "TST | Test Country | Asia | Test Region | 0 | Test Capital",
                result
        );
    }

    @Test
    void testFormatCountryWithNullCapital() {
        App app = new App();

        String result = app.formatCountry(
                "TST", "Test Country", "Asia",
                "Test Region", 1000, null
        );

        assertEquals(
                "TST | Test Country | Asia | Test Region | 1000 | null",
                result
        );
    }
}
