package com.tutorials.core.records;

/**
 * A record gets a canonical constructor, accessors named after the
 * components (not getX()/getY()), equals()/hashCode() by value, and
 * toString() — all generated, all consistent, none of it hand-written
 * (and none of it forgettable, unlike a hand-rolled equals()).
 */
public record Point(int x, int y) implements Comparable<Point> {
    // Extra instance method — records aren't limited to just their components.
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point other) {
        return Double.compare(this.distanceToOrigin(), other.distanceToOrigin());
    }
}
