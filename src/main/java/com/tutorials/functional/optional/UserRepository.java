package com.tutorials.functional.optional;

import java.util.Map;
import java.util.Optional;

/**
 * `Optional<T>` is a return-type-only tool for "this lookup might not find
 * anything" — it should never be a field, a method parameter, or wrap a
 * collection (an empty List already means "nothing found").
 */
public class UserRepository {
    private final Map<String, User> byEmail;

    public UserRepository(Map<String, User> byEmail) {
        this.byEmail = byEmail;
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(byEmail.get(email));
    }
}
