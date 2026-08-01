package com.tutorials.language.patternmatching;

public class InventoryItem {
    private final String sku;
    private final int quantity;

    public InventoryItem(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String sku() {
        return sku;
    }

    public int quantity() {
        return quantity;
    }

    // Pattern variable `item` is only in scope where the compiler can prove
    // the instanceof check succeeded — including after `&&`, which is what
    // makes this read like a single condition instead of a check-then-cast.
    public static boolean isLowStock(Object obj) {
        return obj instanceof InventoryItem item && item.quantity() < 5;
    }
}
