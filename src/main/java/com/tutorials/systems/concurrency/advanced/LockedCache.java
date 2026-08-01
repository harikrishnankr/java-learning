package com.tutorials.systems.concurrency.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock is `synchronized`'s explicit cousin: same mutual exclusion,
 * but with capabilities intrinsic locks don't have — tryLock() with a
 * timeout (bail out instead of blocking forever) and lockInterruptibly().
 * The lock/unlock pair MUST be in try/finally, since unlike `synchronized`
 * the compiler won't release it for you on an exception.
 */
public class LockedCache<K, V> {
    private final Map<K, V> data = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void put(K key, V value) {
        lock.lock();
        try {
            data.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public Optional<V> tryGet(K key, long timeout, TimeUnit unit) throws InterruptedException {
        if (!lock.tryLock(timeout, unit)) {
            return Optional.empty(); // gave up instead of blocking indefinitely
        }
        try {
            return Optional.ofNullable(data.get(key));
        } finally {
            lock.unlock();
        }
    }
}
