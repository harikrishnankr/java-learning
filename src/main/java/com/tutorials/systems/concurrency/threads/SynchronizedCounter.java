package com.tutorials.systems.concurrency.threads;

/**
 * `synchronized` on an instance method acquires the intrinsic lock on
 * `this` for the method's duration — only one thread can be inside any
 * synchronized method of the same instance at a time, and the lock also
 * guarantees the writing thread's changes become visible to the next
 * thread that acquires it (the memory-visibility half of thread safety,
 * not just mutual exclusion).
 */
public class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}
