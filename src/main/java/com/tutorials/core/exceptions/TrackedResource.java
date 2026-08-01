package com.tutorials.core.exceptions;

import java.util.List;

/**
 * try-with-resources closes AutoCloseable resources automatically, in the
 * REVERSE order they were declared — and if both the try body and close()
 * throw, the close() exception is not lost: it's attached to the primary
 * exception's suppressed list instead of replacing it.
 */
public class TrackedResource implements AutoCloseable {
    private final String name;
    private final List<String> closeLog;
    private final boolean failOnClose;

    public TrackedResource(String name, List<String> closeLog, boolean failOnClose) {
        this.name = name;
        this.closeLog = closeLog;
        this.failOnClose = failOnClose;
    }

    @Override
    public void close() throws Exception {
        closeLog.add(name);
        if (failOnClose) {
            throw new Exception("failed to close " + name);
        }
    }
}
