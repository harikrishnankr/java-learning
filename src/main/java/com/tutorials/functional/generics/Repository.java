package com.tutorials.functional.generics;

import java.util.List;
import java.util.Optional;

// Two independent type parameters: T for the stored entity, ID for its key.
// Every implementation gets full compile-time type safety without casting.
public interface Repository<T, ID> {
    void save(ID id, T item);

    Optional<T> findById(ID id);

    List<T> findAll();
}
