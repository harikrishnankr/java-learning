package com.tutorials.language.patternmatching;

/**
 * Pattern matching for switch (finalized in Java 21) replaces
 * instanceof-and-cast chains with a single exhaustive expression. Type
 * patterns bind a variable of the matched type; `when` clauses add a guard
 * condition; and unlike a classic switch, `case null` can be handled
 * explicitly instead of throwing a NullPointerException before the switch runs.
 */
public class Classifier {
    public static String classify(Object obj) {
        return switch (obj) {
            case null -> "null";
            case Integer i when i < 0 -> "negative integer";
            case Integer i when i == 0 -> "zero";
            case Integer i -> "positive integer: " + i;
            case String s when s.isBlank() -> "blank string";
            case String s -> "string of length " + s.length();
            default -> "unknown: " + obj.getClass().getSimpleName();
        };
    }
}
