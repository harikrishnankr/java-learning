package com.tutorials.core.oop.polymorphism;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public Rectangle scaled(double factor) {
        return new Rectangle(width * factor, height * factor);
    }
}
