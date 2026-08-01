package com.tutorials.functional.lambdas;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Accepting java.util.function types as parameters (instead of a custom
 * interface) is the idiomatic way to make a method's behavior pluggable —
 * callers pass a lambda, a method reference, or any object implementing
 * the interface, with zero boilerplate on the receiving end.
 */
public class StringPipeline {
    public static String transform(String input, Function<String, String> transformer) {
        return transformer.apply(input);
    }

    public static boolean allMatch(List<String> items, Predicate<String> predicate) {
        return items.stream().allMatch(predicate);
    }

    public static String orDefault(String input, Supplier<String> fallback) {
        // Supplier defers the computation — fallback.get() only runs if input is blank,
        // unlike a plain default *value* which would always be evaluated eagerly.
        return (input == null || input.isBlank()) ? fallback.get() : input;
    }

    public static int validate(String input, Validator<String> validator) {
        return validator.isValid(input) ? 1 : 0;
    }
}
