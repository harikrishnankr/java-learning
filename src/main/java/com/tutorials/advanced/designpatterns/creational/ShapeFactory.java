package com.tutorials.advanced.designpatterns.creational;

/**
 * Factory Method: callers ask for "a circle" or "a square" without ever
 * naming the concrete class — construction logic is centralized here
 * instead of scattered across every call site with `new`.
 */
public class ShapeFactory {
    public static Shape create(String type, double size) {
        return switch (type.toLowerCase()) {
            case "circle" -> () -> Math.PI * size * size;
            case "square" -> () -> size * size;
            default -> throw new IllegalArgumentException("unknown shape type: " + type);
        };
    }
}
