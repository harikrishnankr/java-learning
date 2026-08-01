package com.tutorials.advanced.designpatterns.creational;

/**
 * Singleton, the Effective Java way: a single-element enum. The JVM
 * guarantees an enum constant is instantiated exactly once, even under
 * reflection or concurrent classloading — the traditional
 * private-constructor-plus-static-field version has to defend against both
 * by hand (see LazySingleton for that version and its trade-offs).
 */
public enum AppConfig {
    INSTANCE;

    private String environment = "production";

    public String environment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
