package com.tutorials.functional.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class GenericMethodUtils {
    // The <T> here is the method's OWN type parameter — independent of any
    // class-level type parameter. It's inferred from the call site's argument.
    public static <T> List<T> repeat(T value, int times) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            result.add(value);
        }
        return result;
    }

    // Multiple independent type parameters on one generic method.
    public static <A, B, R> R combine(A a, B b, BiFunction<A, B, R> combiner) {
        return combiner.apply(a, b);
    }
}
