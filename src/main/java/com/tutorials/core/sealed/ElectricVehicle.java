package com.tutorials.core.sealed;

// non-sealed re-opens the hierarchy from this point on — anyone, in any
// package, may extend ElectricVehicle freely. Sealing is opt-in per branch.
public non-sealed class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model) {
        super(model);
    }
}
