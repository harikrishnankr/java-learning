package com.tutorials.core.sealed;

// Each permitted subclass must declare itself final, sealed, or non-sealed —
// there's no silent "open by default" the way plain `extends` normally is.
public abstract sealed class Vehicle permits Car, Truck, ElectricVehicle {
    protected final String model;

    protected Vehicle(String model) {
        this.model = model;
    }

    public String model() {
        return model;
    }
}
