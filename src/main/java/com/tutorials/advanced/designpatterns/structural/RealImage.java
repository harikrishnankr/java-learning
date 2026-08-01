package com.tutorials.advanced.designpatterns.structural;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // expensive — this is exactly what ProxyImage defers
    }

    private void loadFromDisk() {
        System.out.println("loading " + filename + " from disk");
    }

    @Override
    public void display() {
        System.out.println("displaying " + filename);
    }
}
