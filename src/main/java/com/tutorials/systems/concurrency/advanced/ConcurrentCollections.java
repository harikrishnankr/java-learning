package com.tutorials.systems.concurrency.advanced;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.util.concurrent collections trade off differently than the manual
 * BoundedBuffer in concurrency.threads:
 * - ConcurrentHashMap: lock-striped, safe concurrent reads/writes without
 *   locking the whole map; compute()/merge() update atomically per key.
 * - CopyOnWriteArrayList: every write copies the whole backing array — a
 *   good fit only when reads vastly outnumber writes (e.g. listener lists).
 * - ArrayBlockingQueue: put()/take() block automatically, replacing the
 *   hand-rolled wait()/notifyAll() dance entirely.
 */
public class ConcurrentCollections {
    private final ConcurrentHashMap<String, Integer> hitCounts = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<Runnable> listeners = new CopyOnWriteArrayList<>();

    public int recordHit(String key) {
        // merge() reads, combines, and writes atomically — no external locking needed.
        return hitCounts.merge(key, 1, Integer::sum);
    }

    public void addListener(Runnable listener) {
        listeners.add(listener);
    }

    public void fireAll() {
        // Safe to iterate while another thread mutates listeners — CopyOnWriteArrayList's
        // iterator works against a fixed snapshot taken when iteration started.
        for (Runnable listener : listeners) {
            listener.run();
        }
    }

    public static BlockingQueue<String> newBoundedQueue(int capacity) {
        return new ArrayBlockingQueue<>(capacity);
    }

    public static void produceAndConsume(BlockingQueue<String> queue, List<String> items) throws InterruptedException {
        for (String item : items) {
            queue.put(item); // blocks automatically if the queue is full
        }
    }
}
