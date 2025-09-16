package day16;

import java.util.*;
import java.util.stream.*;

@FunctionalInterface
interface BonusCalculator{
    double getBonus(double salary);
}

class Employee {
    String name;
    int age;
    double salary;

        Employee(String name, int age,  double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeInfo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Manan", 21, 160000),
                new Employee("Randstad", 41, 400000),
                new Employee("Walmart", 75, 800000)
        );

        BonusCalculator bonus = salary -> salary * 0.15;
        System.out.println("Bonus: ");
        employees.forEach(e->
                System.out.println(e.name+ ": " + bonus.getBonus(e.salary)));

        List<String> result = employees.stream()
                .filter(e->e.salary>300000) // filter salary above 300000
                .sorted(Comparator.comparingInt(e->e.age)) // sort by age
                .map(e->e.name.toUpperCase())
                .toList();

        System.out.println("\nStream: ");
        System.out.println(result);
    }
}
