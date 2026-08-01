package com.tutorials.functional.generics;

import java.util.Collection;
import java.util.List;

/**
 * PECS — "Producer Extends, Consumer Super". Use `? extends T` for a
 * parameter you only read from (a producer of T), and `? super T` for a
 * parameter you only write to (a consumer of T). Getting this right is what
 * lets callers pass a {@code List<Integer>} where a {@code Collection<?
 * extends Number>} is expected, without the API being any less type-safe.
 */
public class WildcardUtils {
    // Reads Numbers out of the collection — it only ever produces values for us.
    public static double sumAll(Collection<? extends Number> numbers) {
        double total = 0;
        for (Number n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }

    // Writes Integers into the list — it only ever consumes values from us.
    // `List<? super Integer>` accepts List<Integer>, List<Number>, List<Object>.
    public static void addOneToFive(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }
}
