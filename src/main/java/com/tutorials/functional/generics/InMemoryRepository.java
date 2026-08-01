package com.tutorials.functional.generics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository<T, ID> implements Repository<T, ID> {
    private final Map<ID, T> store = new LinkedHashMap<>();

    @Override
    public void save(ID id, T item) {
        store.put(id, item);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<T> findAll() {
        return List.copyOf(store.values());
    }
}
