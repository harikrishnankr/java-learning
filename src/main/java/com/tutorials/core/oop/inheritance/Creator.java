package com.tutorials.core.oop.inheritance;

public class Creator {
  public static void main(String[] args) {
    Employee e = new Employee("Alice", 100_000);
    System.out.println(e.payslip()); // Alice: base=100000.0 bonus=2000.0
    System.out.println(Employee.department()); // General

    Manager m = new Manager("Bob", 120_000, 5);
    System.out.println(m.payslip()); // Bob: base=120000.0 bonus=3500.0
    System.out.println(Manager.department()); // Management

    Engineer eng = new Engineer("Charlie", 110_000, 10);
    System.out.println(eng.payslip()); // Charlie: base=110000.0 bonus=4000.0
    System.out.println(Engineer.department()); // General
  }
}
