package com.tutorials.core.oop.abstraction;

public class PaypalProcessor extends PaymentProcessor {
    public PaypalProcessor(String merchantId) {
        super(merchantId);
    }

    @Override
    protected AuthorizationResult authorize(double amount) {
        return new AuthorizationResult("PayPal", amount, newConfirmationCode());
    }
}
