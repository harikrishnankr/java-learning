package com.tutorials.advanced.designpatterns.structural;

/**
 * Virtual Proxy: same interface as RealImage, but defers construction of
 * the expensive real object until it's actually needed (first display()
 * call) — callers that create a ProxyImage and never display it never pay
 * the loading cost at all.
 */
public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // lazy initialization
        }
        realImage.display();
    }
}
