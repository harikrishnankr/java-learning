package com.tutorials.functional.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * The four kinds of method reference, each one a shorthand for a lambda that
 * just calls an existing method:
 */
public class MethodReferences {
    // 1. Static method reference — ClassName::staticMethod
    public static final Function<String, Integer> PARSE_INT = Integer::parseInt;

    // 2. Instance method reference on a particular, already-existing object — instance::method
    private final String prefix = "id-";
    public final Function<String, String> prependPrefix = prefix::concat;

    // 3. Instance method reference on an arbitrary object of a type, supplied at call time —
    //    ClassName::instanceMethod. The first lambda parameter becomes the receiver.
    public static final BiFunction<String, String, Boolean> STARTS_WITH = String::startsWith;

    // 4. Constructor reference — ClassName::new
    public static final Supplier<StringBuilder> NEW_BUILDER = StringBuilder::new;
}
