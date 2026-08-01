package com.tutorials.core.objectcontracts;

import java.util.Objects;

/**
 * equals()/hashCode() are keyed on the immutable business identifier (id)
 * only — not name or salary, which can legitimately change without the
 * object's *identity* changing. Two Employees with the same id are "the
 * same employee" even if one record is stale.
 *
 * Uses `instanceof` (not getClass()==getClass()) so a well-behaved subclass
 * can still be equal to a base instance, as long as it doesn't add fields
 * that break symmetry.
 */
public final class Employee implements Comparable<Employee> {
    private final String id;
    private final String name;
    private final double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String id() {
        return id;
    }

    public double salary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee other)) return false;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        // Must be consistent with equals(): equal objects -> equal hash codes.
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{id=%s, name=%s, salary=%.2f}".formatted(id, name, salary);
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
}
