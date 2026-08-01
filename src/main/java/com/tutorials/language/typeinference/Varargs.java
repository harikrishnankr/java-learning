package com.tutorials.language.typeinference;

/**
 * `T...` is sugar for a `T[]` parameter — callers can pass individual
 * arguments, an existing array, or nothing at all. It must be the LAST
 * parameter, and a class can have at most one varargs method per name
 * before overload resolution against fixed-arity overloads gets ambiguous.
 */
public class Varargs {
    public static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    public static String join(String separator, String... parts) {
        return String.join(separator, parts);
    }
}
