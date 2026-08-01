package com.tutorials.systems.concurrency.threads;

/**
 * `count++` is really three steps: read, increment, write. Two threads can
 * both read the same value before either writes back, and one increment is
 * silently lost. This class exists to demonstrate the bug — see
 * SynchronizedCounter for the fix.
 */
public class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int get() {
        return count;
    }
}
