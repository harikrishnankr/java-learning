package com.tutorials.systems.concurrency.threads;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The classic wait()/notifyAll() producer-consumer pattern — worth learning
 * once to understand what BlockingQueue does under the hood, even though in
 * production code you'd reach for java.util.concurrent.BlockingQueue instead
 * (see the concurrency.advanced package) rather than hand-roll this.
 *
 * wait() must always be called in a loop, re-checking the condition — a
 * spurious wakeup or a stolen notification (another consumer got there
 * first) can otherwise let a thread proceed against a now-false condition.
 */
public class BoundedBuffer<T> {
    private final Deque<T> items = new ArrayDeque<>();
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (items.size() == capacity) {
            wait(); // release the lock and sleep until notified
        }
        items.addLast(item);
        notifyAll(); // wake any consumer(s) blocked in take()
    }

    public synchronized T take() throws InterruptedException {
        while (items.isEmpty()) {
            wait();
        }
        T item = items.removeFirst();
        notifyAll(); // wake any producer(s) blocked in put()
        return item;
    }

    public synchronized int size() {
        return items.size();
    }
}
