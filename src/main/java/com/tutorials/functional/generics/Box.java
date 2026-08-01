package com.tutorials.functional.generics;

/**
 * Bounded type parameter: `T extends Comparable<T>` restricts Box to types
 * that can be compared to themselves, which is what makes max() possible
 * without an unchecked cast. Generics are erased at compile time — there is
 * no `T.class` and no `new T[]` anywhere in this class; the bound only
 * exists for the compiler, not at runtime.
 */
public class Box<T extends Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T max(Box<T> other) {
        return value.compareTo(other.value) >= 0 ? value : other.value;
    }
}
