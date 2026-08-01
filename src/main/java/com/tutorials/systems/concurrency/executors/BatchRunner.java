package com.tutorials.systems.concurrency.executors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// invokeAll() submits a whole batch and blocks until every task is done —
// simpler than TaskRunner's manual submit-then-collect loop when you don't
// need to react to individual results as they complete.
public class BatchRunner {
    public static List<Future<Integer>> runAll(List<Callable<Integer>> tasks) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {
            return pool.invokeAll(tasks);
        } finally {
            pool.shutdown();
        }
    }
}
