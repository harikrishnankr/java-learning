package com.tutorials.core.exceptions;

public class Account {
    private final String id;
    private double balance;

    public Account(String id, double balance) {
        if (id == null || id.isBlank()) {
            throw new InvalidAccountException("account id must not be blank");
        }
        this.id = id;
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "cannot withdraw %.2f from account %s with balance %.2f".formatted(amount, id, balance));
        }
        balance -= amount;
    }

    public double balance() {
        return balance;
    }
}
