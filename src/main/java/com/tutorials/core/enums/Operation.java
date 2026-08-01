package com.tutorials.core.enums;

/**
 * Enums are full classes: they can have constructors, fields, methods — and
 * each constant can override a method with its own constant-specific body,
 * which replaces a switch statement with dispatch the compiler enforces is
 * exhaustive (every constant must supply an implementation).
 */
public enum Operation {
    PLUS("+") {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("division by zero");
            }
            return a / b;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double a, double b);

    public String symbol() {
        return symbol;
    }
}
