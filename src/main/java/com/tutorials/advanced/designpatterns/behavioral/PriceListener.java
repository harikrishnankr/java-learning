package com.tutorials.advanced.designpatterns.behavioral;

@FunctionalInterface
public interface PriceListener {
    void onPriceChanged(String symbol, double newPrice);
}
