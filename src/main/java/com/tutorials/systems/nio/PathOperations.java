package com.tutorials.systems.nio;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * java.nio.file (Java 7+, "NIO.2") replaced java.io.File's error-prone
 * boolean-returning methods with a Path type plus a Files utility class
 * that throws real exceptions and returns Streams for bulk operations.
 */
public class PathOperations {
    public static Path resolveChild(Path base, String child) {
        // resolve() joins paths; normalize() collapses "." and ".." segments.
        return base.resolve(child).normalize();
    }

    public static List<String> readAllLines(Path file) {
        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void writeLines(Path file, List<String> lines) {
        try {
            Files.write(file, lines);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // Files.walk() returns a Stream that holds an open file-system resource —
    // it MUST be used inside try-with-resources, unlike most other streams.
    public static long countRegularFiles(Path directory) {
        try (Stream<Path> paths = Files.walk(directory)) {
            return paths.filter(Files::isRegularFile).count();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
