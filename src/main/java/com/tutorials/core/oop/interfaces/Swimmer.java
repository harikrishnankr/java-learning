package com.tutorials.core.oop.interfaces;

public interface Swimmer {
    default String move() {
        return "swimming";
    }
}
