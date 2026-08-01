package com.tutorials.core.oop.abstraction;

public class StripeProcessor extends PaymentProcessor {
    public StripeProcessor(String merchantId) {
        super(merchantId);
    }

    @Override
    protected AuthorizationResult authorize(double amount) {
        return new AuthorizationResult("Stripe", amount, newConfirmationCode());
    }
}
