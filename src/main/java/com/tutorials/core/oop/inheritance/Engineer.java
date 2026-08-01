package com.tutorials.core.oop.inheritance;

public class Engineer extends Employee {
    private final int onCallWeeks;

    public Engineer(String name, double baseSalary, int onCallWeeks) {
        super(name, baseSalary);
        this.onCallWeeks = onCallWeeks;
    }

    @Override
    public double annualBonus() {
        return super.annualBonus() + onCallWeeks * 200;
    }
}
