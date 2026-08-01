package com.tutorials.core.records;

/**
 * Stores money as integer cents, never a double — floating point cannot
 * represent most decimal fractions exactly, so arithmetic on it silently
 * drifts. A static factory (`of`) does the lossy double -> long conversion
 * once, at the boundary, instead of scattering rounding logic everywhere.
 */
public record Money(long cents, String currency) {
    public static Money of(double amount, String currency) {
        return new Money(Math.round(amount * 100), currency);
    }

    public Money plus(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("currency mismatch: " + currency + " vs " + other.currency);
        }
        return new Money(cents + other.cents, currency);
    }

    @Override
    public String toString() {
        return "%d.%02d %s".formatted(cents / 100, Math.abs(cents % 100), currency);
    }
}
