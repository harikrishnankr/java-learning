package com.tutorials.core.oop.interfaces;

/**
 * Duck implements two interfaces that both supply a default {@code move()}.
 * That's the "diamond problem" for default methods: the compiler refuses to
 * pick one for you and forces this class to resolve the conflict explicitly.
 */
public class Duck implements Flyer, Swimmer {
    @Override
    public String move() {
        return Flyer.super.move() + " and " + Swimmer.super.move();
    }
}
