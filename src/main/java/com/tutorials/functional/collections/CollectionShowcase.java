package com.tutorials.functional.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Picking the right collection implementation is a design decision, not a
 * default. Each method below picks one deliberately and says why.
 */
public class CollectionShowcase {
    // ArrayList: O(1) random access, O(n) insert/remove in the middle — the
    // right default for "mostly read, occasionally append" workloads.
    public static List<String> randomAccessList() {
        return new ArrayList<>(List.of("a", "b", "c"));
    }

    // ArrayDeque: O(1) push/pop at both ends, no capacity/locking overhead —
    // prefer it over LinkedList (and even Stack) for stack/queue use cases.
    public static Deque<String> stack() {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("first");
        stack.push("second");
        return stack;
    }

    // TreeSet: keeps elements sorted at all times, O(log n) insert/contains —
    // pay that cost only when you actually need ordering, not just uniqueness.
    public static TreeSet<Integer> sortedUniqueNumbers() {
        return new TreeSet<>(List.of(5, 3, 5, 1, 4));
    }

    // LinkedHashSet: uniqueness like HashSet, but preserves insertion order —
    // useful when "no duplicates" and "predictable iteration" both matter.
    public static LinkedHashSet<String> insertionOrderedUnique() {
        return new LinkedHashSet<>(List.of("z", "a", "z", "m"));
    }

    // TreeMap: keys sorted by their natural order (or a supplied Comparator),
    // with O(log n) navigation methods like firstKey()/ceilingKey().
    public static TreeMap<String, Integer> alphabeticalScores() {
        TreeMap<String, Integer> scores = new TreeMap<>();
        scores.put("charlie", 3);
        scores.put("alice", 1);
        scores.put("bob", 2);
        return scores;
    }

    // Comparator chaining: sort by one key, break ties with another — reads
    // top-to-bottom in priority order instead of one tangled compareTo().
    public static List<String> sortByLengthThenAlphabetically(List<String> words) {
        List<String> sorted = new ArrayList<>(words);
        sorted.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        return sorted;
    }

    // Collections.unmodifiableList wraps (doesn't copy) — mutations to the
    // backing list are still visible through the wrapper, only writes
    // *through the wrapper itself* are blocked. Contrast with List.copyOf,
    // which snapshots and fully decouples from the source (see immutability topic).
    public static List<String> readOnlyView(List<String> backing) {
        return Collections.unmodifiableList(backing);
    }
}
