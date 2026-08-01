package com.tutorials.language.typeinference;

import java.util.Map;

/**
 * Autoboxing hides two sharp edges behind seemingly-primitive syntax:
 * (1) boxed == compares references, and the JVM only guarantees a shared
 * cache for Integer values in [-128, 127]; (2) unboxing a null Integer/etc.
 * throws NullPointerException at the point of the implicit .intValue() call.
 */
public class AutoboxingPitfalls {
    public static boolean cachedIntegersShareAnInstance() {
        Integer a = 127;
        Integer b = 127;
        return a == b; // true — both within the cached range, same instance
    }

    public static boolean uncachedIntegersDoNotShareAnInstance() {
        Integer a = 128;
        Integer b = 128;
        return a == b; // false — outside the cache, two distinct instances
    }

    // A missing key returns a null Integer; assigning it to `int` triggers
    // an implicit unboxing call that throws NullPointerException.
    public static int countFor(Map<String, Integer> counts, String key) {
        return counts.get(key);
    }

    // The safe version: work with the boxed type, or supply a default.
    public static int countForOrZero(Map<String, Integer> counts, String key) {
        return counts.getOrDefault(key, 0);
    }
}
