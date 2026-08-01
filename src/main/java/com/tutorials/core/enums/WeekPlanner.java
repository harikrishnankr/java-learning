package com.tutorials.core.enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * EnumMap/EnumSet are backed by arrays indexed by ordinal — faster and more
 * compact than HashMap/HashSet, and iteration always follows declaration
 * order rather than hash order. Use them whenever the key type is an enum.
 */
public class WeekPlanner {
    private final Map<DayOfWeekPlan, String> tasks = new EnumMap<>(DayOfWeekPlan.class);

    public void plan(DayOfWeekPlan day, String task) {
        tasks.put(day, task);
    }

    public Map<DayOfWeekPlan, String> tasks() {
        return tasks;
    }

    public Set<DayOfWeekPlan> weekend() {
        return EnumSet.of(DayOfWeekPlan.SATURDAY, DayOfWeekPlan.SUNDAY);
    }
}
