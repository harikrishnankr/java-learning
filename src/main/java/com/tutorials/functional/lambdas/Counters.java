package com.tutorials.functional.lambdas;

import java.util.function.Supplier;

/**
 * A lambda can only capture local variables that are (effectively) final —
 * assigned exactly once. That's why a counter closure can't just increment
 * a captured `int`; it captures a mutable holder object instead, whose
 * *reference* never changes even though its *contents* do.
 */
public class Counters {
    public static Supplier<Integer> startingAt(int initial) {
        int[] count = {initial}; // the array reference is effectively final; its slot isn't
        return () -> count[0]++;
    }
}
