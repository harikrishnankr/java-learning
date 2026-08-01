package com.tutorials.advanced.designpatterns.behavioral;

public class Checkout {
    private final PricingStrategy strategy;

    public Checkout(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double total(double baseAmount) {
        return strategy.price(baseAmount);
    }
}
