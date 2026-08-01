package com.tutorials.advanced.testing;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * This class is itself the tutorial content for the "testing" topic — a
 * tour of JUnit 5 features, as opposed to a test suite covering some other
 * topic's production code (that's why it lives alongside Calculator, a
 * class that exists purely to have something small to exercise below).
 */
class JUnitFeaturesTest {
    private Calculator calculator;

    // Runs before EVERY @Test method — gives each test a fresh instance so
    // tests can't leak state into one another regardless of execution order.
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    @DisplayName("basic assertion")
    void additionWorks() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("assertThrows captures and lets you inspect the thrown exception")
    void divisionByZeroThrows() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("division by zero", ex.getMessage());
    }

    @Test
    @DisplayName("assertAll runs every assertion even if an earlier one fails, reporting all failures together")
    void groupedAssertions() {
        assertAll(
                () -> assertEquals(4, calculator.add(2, 2)),
                () -> assertEquals(0, calculator.add(0, 0)),
                () -> assertEquals(-1, calculator.add(1, -2)));
    }

    // @ParameterizedTest runs the same test body once per source value —
    // instead of copy-pasting the same test with different literals.
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100})
    @DisplayName("dividing by itself always yields 1")
    void divisionBySelfIsOne(int value) {
        assertEquals(1, calculator.divide(value, value));
    }

    // CsvSource supplies multiple parameters per invocation, comma-separated.
    @ParameterizedTest
    @CsvSource({"2,3,5", "0,0,0", "-1,1,0", "10,-5,5"})
    @DisplayName("addition across a table of inputs and expected outputs")
    void additionTable(int a, int b, int expectedSum) {
        assertEquals(expectedSum, calculator.add(a, b));
    }

    @Test
    @DisplayName("assumeTrue skips the test instead of failing it when a precondition isn't met")
    void assumptionSkipsWhenPreconditionFails() {
        Assumptions.assumeTrue(Runtime.version().feature() >= 17, "requires Java 17+");
        assertEquals(2, calculator.add(1, 1));
    }

    // @Nested groups related tests into their own inner class — each nested
    // class gets its own @BeforeEach/@AfterEach lifecycle, and the grouping
    // shows up in test reports as a readable hierarchy.
    @Nested
    @DisplayName("edge cases around zero")
    class ZeroEdgeCases {
        @Test
        @DisplayName("zero plus zero is zero")
        void zeroPlusZero() {
            assertEquals(0, calculator.add(0, 0));
        }

        @Test
        @DisplayName("dividing zero by a non-zero number is zero")
        void zeroDividedByNumber() {
            assertEquals(0, calculator.divide(0, 5));
        }
    }
}
