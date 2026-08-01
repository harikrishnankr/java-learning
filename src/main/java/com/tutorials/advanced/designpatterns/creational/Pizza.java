package com.tutorials.advanced.designpatterns.creational;

/**
 * Builder: for a type with several optional fields, a telescoping
 * constructor (or a mutable setter-based bean) is either combinatorially
 * ugly or leaves the object inconsistent between setter calls. A fluent
 * builder collects everything first and validates it once, in build(),
 * before producing a fully-formed, immutable Pizza.
 */
public final class Pizza {
    private final String size;
    private final boolean extraCheese;
    private final boolean stuffedCrust;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.extraCheese = builder.extraCheese;
        this.stuffedCrust = builder.stuffedCrust;
    }

    public String size() {
        return size;
    }

    public boolean extraCheese() {
        return extraCheese;
    }

    public boolean stuffedCrust() {
        return stuffedCrust;
    }

    public static Builder builder(String size) {
        return new Builder(size);
    }

    public static final class Builder {
        private final String size;
        private boolean extraCheese;
        private boolean stuffedCrust;

        private Builder(String size) {
            this.size = size;
        }

        public Builder extraCheese() {
            this.extraCheese = true;
            return this;
        }

        public Builder stuffedCrust() {
            this.stuffedCrust = true;
            return this;
        }

        public Pizza build() {
            if (size == null || size.isBlank()) {
                throw new IllegalStateException("size is required");
            }
            return new Pizza(this);
        }
    }
}
