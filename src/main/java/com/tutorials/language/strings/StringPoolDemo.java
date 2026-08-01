package com.tutorials.language.strings;

/**
 * String literals are interned automatically: the JVM keeps one canonical
 * instance per distinct literal value in a pool, and every occurrence of
 * that literal in the source refers to the same object. `new String(...)`
 * opts out of that and always allocates a fresh object.
 *
 * This is exactly why you compare strings with equals(), never ==: == only
 * happens to work for literals because of the pool, and silently breaks the
 * moment a String arrives from I/O, concatenation, or `new`.
 */
public class StringPoolDemo {
    public static boolean sameLiteralInstance() {
        String a = "hello";
        String b = "hello";
        return a == b; // true — both refer to the same pooled instance
    }

    public static boolean newInstanceIsDifferent() {
        String a = "hello";
        String b = new String("hello");
        return a == b; // false — `new` bypasses the pool
    }

    public static boolean internReturnsToThePool() {
        String a = "hello";
        String b = new String("hello").intern();
        return a == b; // true — intern() explicitly finds/adds the pooled instance
    }
}
