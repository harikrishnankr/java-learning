package com.tutorials.systems.concurrency.advanced;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture composes asynchronous steps declaratively instead of
 * nesting callbacks: thenApply transforms a result, thenCompose chains
 * another async step (flatMap for futures), exceptionally recovers from a
 * failure, and allOf waits for a batch to finish without blocking each one
 * in turn.
 */
public class AsyncPipeline {
    public static CompletableFuture<String> fetchAndFormat(String userId) {
        return CompletableFuture.supplyAsync(() -> fetchUserName(userId))
                .thenApply(name -> "Hello, " + name)
                .exceptionally(ex -> "Hello, guest (lookup failed: " + ex.getMessage() + ")");
    }

    public static CompletableFuture<String> fetchThenFetchOrders(String userId) {
        return CompletableFuture.supplyAsync(() -> fetchUserName(userId))
                .thenCompose(name -> CompletableFuture.supplyAsync(() -> name + "'s orders"));
    }

    public static CompletableFuture<Void> fetchAllUsers(List<String> userIds) {
        List<CompletableFuture<String>> futures = userIds.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> fetchUserName(id)))
                .toList();
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    private static String fetchUserName(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
        return "user-" + userId;
    }
}
