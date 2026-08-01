package com.tutorials.advanced.designpatterns.structural;

/**
 * Adapter: wraps an incompatible interface (String-returning legacy service)
 * to satisfy the interface the rest of the app expects (double-returning
 * RateProvider) — without modifying the legacy class, which this codebase
 * may not even own the source of.
 */
public class LegacyRateAdapter implements RateProvider {
    private final LegacyRateService legacyService;

    public LegacyRateAdapter(LegacyRateService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public double rate(String currencyCode) {
        return Double.parseDouble(legacyService.fetchRateAsString(currencyCode));
    }
}
