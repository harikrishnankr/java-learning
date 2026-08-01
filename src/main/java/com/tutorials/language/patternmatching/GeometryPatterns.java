package com.tutorials.language.patternmatching;

public class GeometryPatterns {
    public record Point(int x, int y) {
    }

    public record Line(Point start, Point end) {
    }

    // Record patterns nest: this deconstructs a Line straight down to its
    // Points' individual x/y components in one case label, no manual
    // line.start().x() chaining required.
    public static int manhattanLength(Object shape) {
        return switch (shape) {
            case Line(Point(var x1, var y1), Point(var x2, var y2)) ->
                    Math.abs(x2 - x1) + Math.abs(y2 - y1);
            default -> 0;
        };
    }
}
