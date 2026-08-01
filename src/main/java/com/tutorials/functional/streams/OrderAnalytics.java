package com.tutorials.functional.streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A stream is a one-shot pipeline over a source — it doesn't store data and
 * can't be reused after a terminal operation (collect/sum/reduce/...) runs.
 * Each method below is a small, focused example of one stream idiom rather
 * than one giant pipeline, so each idiom stays easy to point at.
 */
public class OrderAnalytics {
    public static double totalRevenue(List<Order> orders) {
        return orders.stream().mapToDouble(Order::amount).sum();
    }

    public static Map<String, List<Order>> byCustomer(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::customer));
    }

    public static Map<String, Double> revenueByCustomer(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::customer, Collectors.summingDouble(Order::amount)));
    }

    public static Optional<Order> biggestOrder(List<Order> orders) {
        return orders.stream().max(java.util.Comparator.comparingDouble(Order::amount));
    }

    public static Map<Boolean, List<Order>> partitionByHighValue(List<Order> orders, double threshold) {
        return orders.stream().collect(Collectors.partitioningBy(o -> o.amount() >= threshold));
    }

    public static String itemsAsCsv(List<Order> orders) {
        return orders.stream().map(Order::item).distinct().sorted().collect(Collectors.joining(", "));
    }

    public static double totalRevenueParallel(List<Order> orders) {
        // Only worth it for large, CPU-bound workloads — the fork/join overhead
        // can easily outweigh the benefit on small collections like this one.
        return orders.parallelStream().mapToDouble(Order::amount).sum();
    }
}
