package com.tutorials.language.strings;

/**
 * Strings are immutable, so `result += piece` in a loop doesn't append —
 * it allocates an entirely new String each iteration and copies everything
 * seen so far into it, making an n-iteration loop O(n^2) in total work.
 * StringBuilder mutates an internal buffer in place, making the same loop O(n).
 */
public class StringBuilderVsConcat {
    // O(n^2): each += allocates a new String of growing length.
    public static String concatWithPlus(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += i;
        }
        return result;
    }

    // O(n): StringBuilder appends into the same growable buffer.
    public static String concatWithBuilder(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(i);
        }
        return builder.toString();
    }
}
