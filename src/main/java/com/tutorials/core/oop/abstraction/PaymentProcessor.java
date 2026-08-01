package com.tutorials.core.oop.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Template Method pattern: the abstract class owns the algorithm's skeleton
 * (validate -> authorize -> log) and state (merchantId), and defers exactly
 * one step to subclasses. Unlike an interface, it can hold shared state and
 * a constructor that enforces an invariant on it — abstract classes model
 * "is-a, and shares this implementation", interfaces model "can-do".
 *
 * Abstract classes can't be instantiated directly (`new PaymentProcessor(...)`
 * would not compile) — only concrete subclasses that fill in `authorize`.
 */
public abstract class PaymentProcessor {
    protected final String merchantId;
    private final List<AuthorizationResult> ledger = new ArrayList<>();

    protected PaymentProcessor(String merchantId) {
        this.merchantId = merchantId;
    }

    // final: every processor must follow the exact same sequence of steps.
    public final AuthorizationResult process(double amount) {
        validate(amount);
        AuthorizationResult result = authorize(amount);
        log(result);
        return result;
    }

    private void validate(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
    }

    private void log(AuthorizationResult result) {
        ledger.add(result);
    }

    public List<AuthorizationResult> ledger() {
        return List.copyOf(ledger);
    }

    // abstract: the one step every subclass MUST supply differently.
    protected abstract AuthorizationResult authorize(double amount);

    protected String newConfirmationCode() {
        return UUID.randomUUID().toString();
    }
}
