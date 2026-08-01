package com.tutorials.advanced.designpatterns.structural;

/**
 * Decorator: wraps a Coffee and implements the SAME interface, so decorators
 * stack (MilkDecorator around SugarDecorator around SimpleCoffee...) and
 * every combination of add-ons is achievable without a subclass per
 * combination — the alternative would be SimpleCoffeeWithMilk,
 * SimpleCoffeeWithMilkAndSugar, and so on, combinatorially.
 */
public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee wrapped;

    protected CoffeeDecorator(Coffee wrapped) {
        this.wrapped = wrapped;
    }
}
