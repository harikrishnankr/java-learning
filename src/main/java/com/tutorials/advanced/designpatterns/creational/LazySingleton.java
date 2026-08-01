package com.tutorials.advanced.designpatterns.creational;

/**
 * The "initialization-on-demand holder" idiom: the nested Holder class isn't
 * loaded (and its static field isn't initialized) until getInstance() is
 * first called, and class initialization is already guaranteed thread-safe
 * by the JVM — so this gets lazy, thread-safe, lock-free singleton
 * initialization without any explicit synchronization.
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static class Holder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return Holder.INSTANCE;
    }
}
