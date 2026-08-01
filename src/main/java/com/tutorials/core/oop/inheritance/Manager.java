package com.tutorials.core.oop.inheritance;

public class Manager extends Employee {
    private final int directReports;

    // Hides Employee.department() — does NOT override it. Which one runs
    // depends on the *compile-time* type of the reference, not the runtime type.
    static String department() {
        return "Management";
    }

    public Manager(String name, double baseSalary, int directReports) {
        super(name, baseSalary); // must run before any Manager-specific init
        this.directReports = directReports;
    }

    @Override
    public double annualBonus() {
        // super.annualBonus() reuses the base calculation instead of duplicating it.
        return super.annualBonus() + directReports * 500;
    }
}
