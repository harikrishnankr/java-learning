package com.tutorials.core.records;

public record Range(int min, int max) {
    // Compact constructor: no parameter list, no explicit field assignment —
    // just validation/normalization before the (implicit) canonical assignment runs.
    public Range {
        if (min > max) {
            throw new IllegalArgumentException("min (%d) must not exceed max (%d)".formatted(min, max));
        }
    }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }
}
