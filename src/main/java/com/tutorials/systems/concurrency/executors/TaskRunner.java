package com.tutorials.systems.concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService decouples "what to run" from "how/where it runs" — a fixed
 * thread pool here, virtual threads in the neighboring package, without
 * changing a single line of task logic. submit() (unlike execute()) returns
 * a Future so the caller can retrieve a result or propagate an exception.
 */
public class TaskRunner {
    public static List<Integer> computeSquares(List<Integer> numbers) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {
            List<Future<Integer>> futures = new ArrayList<>();
            for (int n : numbers) {
                Callable<Integer> task = () -> n * n;
                futures.add(pool.submit(task));
            }

            List<Integer> results = new ArrayList<>();
            for (Future<Integer> future : futures) {
                results.add(future.get()); // blocks until this task's result is ready
            }
            return results;
        } finally {
            pool.shutdown(); // stop accepting new tasks; already-submitted ones still run
        }
    }
}
