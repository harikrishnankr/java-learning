package com.tutorials.core.oop.polymorphism;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    // Covariant return: `Circle` instead of `Shape` — legal because Circle is-a Shape.
    @Override
    public Circle scaled(double factor) {
        return new Circle(radius * factor);
    }
}
