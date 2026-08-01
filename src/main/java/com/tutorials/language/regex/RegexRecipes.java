package com.tutorials.language.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern.compile() is relatively expensive, so a Pattern is compiled once
 * as a constant and reused via matcher() on every call — never compile the
 * same pattern inside a hot loop.
 */
public class RegexRecipes {
    private static final Pattern EMAIL = Pattern.compile("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$");
    private static final Pattern NUMBER = Pattern.compile("\\d+");
    private static final Pattern ISO_DATE =
            Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");

    public static boolean isValidEmail(String candidate) {
        return EMAIL.matcher(candidate).matches();
    }

    public static List<String> extractNumbers(String text) {
        List<String> matches = new ArrayList<>();
        Matcher matcher = NUMBER.matcher(text);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    // Named groups (?<name>...) read far better at the call site than
    // group(1)/group(2)/group(3), which say nothing about what they contain.
    public static Optional<String> extractYear(String isoDate) {
        Matcher matcher = ISO_DATE.matcher(isoDate);
        return matcher.matches() ? Optional.of(matcher.group("year")) : Optional.empty();
    }

    public static String redactDigits(String text) {
        return NUMBER.matcher(text).replaceAll("[REDACTED]");
    }
}
