package com.tutorials.core.oop.polymorphism;

/**
 * Overloading is resolved at COMPILE TIME based on the static types of the
 * arguments — unlike overriding, there is no dynamic dispatch involved.
 * The compiler picks the most specific applicable overload, preferring an
 * exact match, then widening, then autoboxing, then varargs — in that order.
 */
public class OverloadResolver {
    public String resolve(int value) {
        return "int";
    }

    public String resolve(long value) {
        return "long";
    }

    public String resolve(Integer value) {
        return "Integer";
    }

    public String resolve(Object value) {
        return "Object";
    }

    public String resolve(int... values) {
        return "varargs";
    }
}
