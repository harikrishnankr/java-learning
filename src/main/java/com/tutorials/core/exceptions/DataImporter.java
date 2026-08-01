package com.tutorials.core.exceptions;

import java.io.IOException;

public class DataImporter {
    // Multi-catch: one handler for two unrelated checked exception types,
    // instead of duplicating the same recovery logic in two catch blocks.
    public String importSafely(String source) {
        try {
            return parse(source);
        } catch (IOException | InterruptedException e) {
            return "import failed: " + e.getMessage();
        }
    }

    // Exception chaining: wrap a lower-level failure in a higher-level one
    // without losing the original cause — getCause() preserves the full chain.
    public String importOrThrow(String source) {
        try {
            return parse(source);
        } catch (IOException e) {
            throw new RuntimeException("could not import from " + source, e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore the interrupt status before returning
            throw new RuntimeException("import interrupted for " + source, e);
        }
    }

    private String parse(String source) throws IOException, InterruptedException {
        if (source == null) {
            throw new IOException("source is null");
        }
        if (source.equals("interrupt-me")) {
            throw new InterruptedException("simulated interruption");
        }
        return "parsed:" + source;
    }
}
