package com.java30days.day23;

import com.java30days.day23.dao.EmployeeDAO;
import com.java30days.day23.model.Employee;

import java.math.BigDecimal;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.init(); // ensure table exists if your DAO has an init()

        // CREATE
        Employee e = dao.create(new Employee("CLI Tester", "IT", new BigDecimal("52000")));
        System.out.println("Created: " + e);

        // READ ALL
        dao.findAll().forEach(System.out::println);

        // UPDATE
        e.setName("CLI Tester Updated");
        dao.update(e);
        System.out.println("After update:");
        dao.findById(e.getId()).ifPresent(System.out::println);

        // DELETE
        dao.delete(e.getId());
        System.out.println("After delete:");
        dao.findAll().forEach(System.out::println);
    }
}
