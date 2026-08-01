package com.tutorials.core.oop.interfaces;

public interface Flyer {
    default String move() {
        return "flying";
    }
}
