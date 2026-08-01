package com.tutorials.functional.lambdas;

// @FunctionalInterface isn't required for lambda compatibility (any interface
// with exactly one abstract method qualifies) — it's a compiler-enforced
// promise that a second abstract method is never accidentally added later.
@FunctionalInterface
public interface Validator<T> {
    boolean isValid(T value);
}
