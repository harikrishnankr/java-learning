package com.tutorials.core.oop.polymorphism;

public abstract class Shape {
    public abstract double area();

    // Covariant return type: overrides in subclasses may narrow the return
    // type as long as it's a subtype of Shape — the compiler still accepts
    // it as satisfying this contract.
    public abstract Shape scaled(double factor);
}
