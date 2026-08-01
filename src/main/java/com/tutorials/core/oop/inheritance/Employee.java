package com.tutorials.core.oop.inheritance;

public class Employee {
    protected final String name;
    private final double baseSalary;

    // Static methods belong to the class, not an instance — they are resolved
    // at compile time based on the reference's declared type, so they can be
    // *hidden* by a subclass but never *overridden* the way instance methods are.
    static String department() {
        return "General";
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double baseSalary() {
        return baseSalary;
    }

    // Not final: subclasses are expected to override this.
    public double annualBonus() {
        return baseSalary * 0.02;
    }

    // final: part of the contract every subclass must honor unchanged.
    public final String payslip() {
        return name + ": base=" + baseSalary + " bonus=" + annualBonus();
    }
}
