package com.tutorials.advanced.designpatterns.behavioral;

// Strategy: the algorithm (how to price an order) is extracted behind an
// interface and supplied to Checkout at runtime — Checkout never has an
// if/else chain over "which pricing rule applies."
@FunctionalInterface
public interface PricingStrategy {
    double price(double baseAmount);
}
