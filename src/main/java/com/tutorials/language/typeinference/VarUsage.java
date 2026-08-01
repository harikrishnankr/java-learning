package com.tutorials.language.typeinference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * `var` (Java 10+) infers a LOCAL variable's type from its initializer at
 * compile time — it is still statically typed, just written less verbosely.
 * It is only legal for local variables with an initializer; it cannot be
 * used for fields, method parameters, or return types, and there is no such
 * thing as `var` without an initializer (the compiler would have nothing to
 * infer from).
 */
public class VarUsage {
    public static List<String> namesStartingWithA(Map<String, Integer> ages) {
        var result = new ArrayList<String>(); // inferred as ArrayList<String>
        for (var entry : ages.entrySet()) {   // inferred as Map.Entry<String, Integer>
            if (entry.getKey().startsWith("A")) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
