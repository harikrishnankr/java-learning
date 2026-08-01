package com.tutorials.systems.concurrency.advanced;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger uses compare-and-swap (CAS) hardware instructions instead of
 * a lock: "if the value is still what I last read, update it; otherwise
 * retry." That makes simple counter/accumulator updates thread-safe without
 * ever blocking a thread the way `synchronized` would.
 */
public class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    public int increment() {
        return count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }

    // Manual CAS loop — what incrementAndGet() effectively does internally.
    public int incrementManually() {
        int current;
        int next;
        do {
            current = count.get();
            next = current + 1;
        } while (!count.compareAndSet(current, next));
        return next;
    }
}
