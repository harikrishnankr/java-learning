package com.tutorials.core.sealed;

public class ShapeCalculator {
    // No `default` branch, and the compiler still accepts this as exhaustive —
    // it knows Shape permits exactly Circle, Square, Triangle. Add a fourth
    // permitted type later and this switch fails to *compile* until updated.
    public static double area(Shape shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Square s -> s.side() * s.side();
            case Triangle t -> 0.5 * t.base() * t.height();
        };
    }
}
