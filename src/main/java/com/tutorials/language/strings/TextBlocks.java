package com.tutorials.language.strings;

/**
 * A text block (Java 15+) preserves formatting without escaping every quote
 * and newline. Its incidental leading whitespace (the common indentation
 * shared by every line) is stripped automatically based on the position of
 * the closing delimiter.
 */
public class TextBlocks {
    public static final String WELCOME_EMAIL = """
            Hi %s,

            Your order #%d has shipped.

            Thanks!
            """;

    public static String welcomeEmail(String name, int orderId) {
        return WELCOME_EMAIL.formatted(name, orderId);
    }

    public static final String SELECT_ACTIVE_USERS = """
            SELECT id, name
            FROM users
            WHERE active = true
            """;
}
