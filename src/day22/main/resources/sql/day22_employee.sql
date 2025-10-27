-- Day22: create DB and Employee table + sample data
CREATE DATABASE IF NOT EXISTS company_db;
USE company_db;

CREATE TABLE IF NOT EXISTS Employee (
  emp_id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50),
  email VARCHAR(100) UNIQUE,
  department VARCHAR(50),
  salary DECIMAL(10,2),
  hire_date DATE
);

INSERT INTO Employee (first_name, last_name, email, department, salary, hire_date)
VALUES
('Amit','Sharma','amit.sharma@company.com','IT',70000,'2022-01-10'),
('Neha','Verma','neha.verma@company.com','HR',60000,'2021-09-15');
