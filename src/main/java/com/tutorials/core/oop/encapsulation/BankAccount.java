package com.tutorials.core.oop.encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encapsulation isn't just "make fields private" — it's about protecting the
 * invariants of an object so it can never be observed in an invalid state.
 * Every mutation goes through a method that can enforce a rule; nothing
 * outside this class can touch balance/history directly.
 */
public final class BankAccount {
    private final String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("opening balance cannot be negative");
        }
        this.ownerName = ownerName;
        this.balance = openingBalance;
        history.add("OPEN " + openingBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit must be positive");
        }
        balance += amount;
        history.add("DEPOSIT " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("withdrawal must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("insufficient funds");
        }
        balance -= amount;
        history.add("WITHDRAW " + amount);
    }

    public double balance() {
        return balance;
    }

    public String ownerName() {
        return ownerName;
    }

    // Return an unmodifiable view, not the live list — callers must not be able
    // to rewrite history by mutating what we hand them.
    public List<String> history() {
        return Collections.unmodifiableList(history);
    }
}
