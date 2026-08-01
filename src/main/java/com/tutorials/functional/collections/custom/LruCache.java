package com.tutorials.functional.collections.custom;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap already maintains a doubly-linked list through its entries;
 * constructing it in access-order mode moves an entry to the tail on every
 * get()/put(), and overriding removeEldestEntry() turns that ordering into
 * a working LRU cache in about ten lines — no need to hand-roll the linked
 * list yourself.
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LruCache(int capacity) {
        super(16, 0.75f, true); // accessOrder=true: get() counts as a "use"
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
