package com.tutorials.advanced.designpatterns.behavioral;

// Since PricingStrategy is a functional interface, most "implementations"
// are just lambdas — these named constants exist purely for readability
// at call sites, not because a lambda couldn't do the job inline.
public class PricingStrategies {
    public static final PricingStrategy REGULAR = amount -> amount;
    public static final PricingStrategy TEN_PERCENT_OFF = amount -> amount * 0.9;

    public static PricingStrategy flatDiscount(double amountOff) {
        return amount -> Math.max(0, amount - amountOff);
    }
}
