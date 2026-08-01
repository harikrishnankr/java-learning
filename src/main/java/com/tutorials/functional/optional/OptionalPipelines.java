package com.tutorials.functional.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalPipelines {
    private final UserRepository users;

    public OptionalPipelines(UserRepository users) {
        this.users = users;
    }

    // map/orElse chain instead of isPresent()+get(), which reads like the null
    // check it's replacing and is easy to get subtly wrong under refactoring.
    public String displayNameOrAnonymous(String email) {
        return users.findByEmail(email)
                .map(User::displayName)
                .orElse("Anonymous");
    }

    // orElseThrow with a Supplier defers building the exception until it's
    // actually needed — no wasted allocation on the common found-it path.
    public User requireUser(String email) {
        return users.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("no user for " + email));
    }

    // flatMap avoids Optional<Optional<T>> when the mapping function itself
    // returns an Optional.
    public Optional<String> domainOf(String email) {
        return users.findByEmail(email)
                .flatMap(u -> extractDomain(u.email()));
    }

    private Optional<String> extractDomain(String email) {
        int at = email.indexOf('@');
        return at < 0 ? Optional.empty() : Optional.of(email.substring(at + 1));
    }

    // ifPresentOrElse handles both branches without an intermediate boolean check.
    public void logLookup(String email) {
        users.findByEmail(email).ifPresentOrElse(
                u -> System.out.println("found: " + u.displayName()),
                () -> System.out.println("no user for " + email));
    }
}
