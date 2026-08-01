package com.tutorials.advanced.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer: the subject (StockTicker) knows nothing about who's listening
 * or why — it just broadcasts to whatever's registered. This decouples
 * "price changed" from "what should happen when it does," which each
 * listener defines independently.
 */
public class StockTicker {
    private final List<PriceListener> listeners = new ArrayList<>();
    private double price;

    public void subscribe(PriceListener listener) {
        listeners.add(listener);
    }

    public void updatePrice(String symbol, double newPrice) {
        this.price = newPrice;
        for (PriceListener listener : listeners) {
            listener.onPriceChanged(symbol, newPrice);
        }
    }

    public double price() {
        return price;
    }
}
