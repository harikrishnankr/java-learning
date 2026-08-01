package com.tutorials.systems.concurrency.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Virtual threads (finalized in Java 21, JEP 444) are JVM-managed threads
 * that are cheap enough to create millions of — unlike platform threads,
 * which are 1:1 wrappers around an OS thread and expensive to spawn in bulk.
 * They're designed for exactly this shape of workload: many concurrent
 * blocking I/O-bound tasks, where a thread spends most of its life waiting.
 *
 * The executor API is unchanged — swapping newFixedThreadPool() for
 * newVirtualThreadPerTaskExecutor() is the entire migration for code
 * already written against ExecutorService (compare to TaskRunner).
 */
public class VirtualThreadDemo {
    public static List<String> fetchAllConcurrently(List<String> urls) throws InterruptedException, ExecutionException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<String>> tasks = urls.stream()
                    .<Callable<String>>map(url -> () -> simulateBlockingFetch(url))
                    .toList();

            List<Future<String>> futures = new ArrayList<>();
            for (Callable<String> task : tasks) {
                futures.add(executor.submit(task));
            }

            List<String> results = new ArrayList<>();
            for (Future<String> future : futures) {
                results.add(future.get());
            }
            return results;
        } // ExecutorService is AutoCloseable since Java 19 — close() waits for tasks to finish
    }

    public static Thread startVirtualThread(Runnable task) {
        return Thread.ofVirtual().start(task);
    }

    private static String simulateBlockingFetch(String url) {
        try {
            Thread.sleep(10); // stands in for a real blocking network call
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "response from " + url;
    }
}
