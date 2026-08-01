package com.tutorials.functional.collections.custom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementing Iterable<T> is what makes a custom type usable in a for-each
 * loop. The Iterator returned here walks from oldest to newest without
 * exposing the buffer's internal wraparound indexing to the caller at all.
 */
public class CircularBuffer<T> implements Iterable<T> {
    private final Object[] elements;
    private int start = 0;
    private int size = 0;

    public CircularBuffer(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(T element) {
        int writeIndex = (start + size) % elements.length;
        elements[writeIndex] = element;
        if (size < elements.length) {
            size++;
        } else {
            start = (start + 1) % elements.length; // buffer full: overwrite the oldest slot
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = (T) elements[(start + index) % elements.length];
                index++;
                return value;
            }
        };
    }
}
