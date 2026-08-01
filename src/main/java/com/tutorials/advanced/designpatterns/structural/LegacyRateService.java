package com.tutorials.advanced.designpatterns.structural;

// Represents a third-party/legacy API this codebase doesn't control — it
// returns rates as formatted strings, an interface the rest of the app
// should never have to deal with directly.
public class LegacyRateService {
    public String fetchRateAsString(String currencyCode) {
        return switch (currencyCode) {
            case "EUR" -> "0.92";
            case "GBP" -> "0.79";
            default -> "1.00";
        };
    }
}
