package com.tutorials.core.oop.interfaces;

/**
 * Interfaces can carry more than abstract methods: static factories, default
 * methods, and (since Java 9) private helper methods that default methods
 * share without exposing them as part of the public API.
 */
public interface Shape {
    double area();

    // Private interface method — reusable by default methods, invisible to implementers.
    private double rounded(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    default double describeArea() {
        return rounded(area());
    }

    static Shape unitCircle() {
        return () -> Math.PI; // lambda satisfying the single abstract method `area()`
    }
}
