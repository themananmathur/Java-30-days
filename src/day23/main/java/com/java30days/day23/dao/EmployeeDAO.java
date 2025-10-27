package com.java30days.day23.dao;

import com.java30days.day23.DBconfig;
import com.java30days.day23.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {

    public void init() {
        String sql = """
            CREATE TABLE IF NOT EXISTS employee (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                role VARCHAR(100),
                salary DECIMAL(10,2),
                joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            );
        """;
        try (Connection conn = DBconfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing DB", e);
        }
    }

    // CREATE
    public Employee create(Employee emp) {
        String sql = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getRole());
            ps.setBigDecimal(3, emp.getSalary());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) emp.setId(rs.getInt(1));
            }
            return emp;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating employee", e);
        }
    }

    // READ ALL
    public List<Employee> findAll() {
        String sql = "SELECT id, name, role, salary, joined_at FROM employee";
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getBigDecimal("salary")
                );
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading employees", e);
        }
        return list;
    }

    // READ BY ID
    public Optional<Employee> findById(int id) {
        String sql = "SELECT id, name, role, salary, joined_at FROM employee WHERE id = ?";
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("role"),
                            rs.getBigDecimal("salary")
                    );
                    return Optional.of(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding employee", e);
        }
        return Optional.empty();
    }

    // UPDATE
    public boolean update(Employee emp) {
        String sql = "UPDATE employee SET name = ?, role = ?, salary = ? WHERE id = ?";
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getRole());
            ps.setBigDecimal(3, emp.getSalary());
            ps.setInt(4, emp.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating employee", e);
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting employee", e);
        }
    }
}
