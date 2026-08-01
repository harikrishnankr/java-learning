package com.tutorials.core.oop.encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encapsulation isn't just "make fields private" - it's about protecting the
 * invariants of an object so it can never be observed in an invalid state.
 * Every mutation goes through a method that can enforce a rule; nothing
 * outside this class can touch balance/history directly.
 */
public final class BankAccount {
    // Making all the field private final protects them from being changed outside the class.
    private final String ownerName; // final because it should never change after the account is created
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
        return Collections.unmodifiableList(history); // Its a readonly list, no update from outside.
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 100);
        account.deposit(50);
        account.withdraw(30);
        System.out.println(account.balance()); // 120.0
        System.out.println(account.history()); // [OPEN 100.0, DEPOSIT 50.0, WITHDRAW 30.0]

        try {
            account.withdraw(200); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // withdrawal must be positive
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // insufficient funds
        } finally {
            System.out.println(account.balance()); // 120.0
            System.out.println(account.history()); // [OPEN 100.0, DEPOSIT 50.0, WITHDRAW 30.0]
        }
    }
}
