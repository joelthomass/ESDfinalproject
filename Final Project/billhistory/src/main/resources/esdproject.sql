-- Drop database if it already exists
DROP DATABASE IF EXISTS esdproject;

-- Create a new database
CREATE DATABASE esdproject;
USE esdproject;

-- Create `students` table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Insert sample data into `students` table
INSERT INTO students (id, username, password)
VALUES
(101, 'student101', 'password1'),
(102, 'student102', 'password2'),
(103, 'student103', 'password3');

-- Create `bills` table
CREATE TABLE bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    bill_date DATE NOT NULL,
    deadline DATE NOT NULL,
    description VARCHAR(255) NOT NULL
);

-- Insert sample data into `bills` table
INSERT INTO bills (id, amount, bill_date, deadline, description)
VALUES
(1, 1200.50, '2024-11-01', '2024-11-10', 'Electricity Bill'),
(2, 800.75, '2024-11-05', '2024-11-15', 'Water Bill'),
(3, 1500.00, '2024-11-10', '2024-11-20', 'Internet Bill'),
(4, 2500.00, '2024-11-15', '2024-11-25', 'Gym Membership'),
(5, 5000.00, '2024-11-20', '2024-11-30', 'Insurance Premium'),
(6, 1300.25, '2024-11-02', '2024-11-12', 'Electricity Charge'),
(7, 900.50, '2024-11-06', '2024-11-16', 'Water Supply Bill'),
(8, 1600.75, '2024-11-11', '2024-11-21', 'Internet Service Fee'),
(9, 2700.00, '2024-11-16', '2024-11-26', 'Fitness Club Subscription'),
(10, 5500.25, '2024-11-21', '2024-12-01', 'Health Insurance Premium');

-- Create `student_bills` table
CREATE TABLE student_bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    bill_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (bill_id) REFERENCES bills(id)
);

-- Insert sample data into `student_bills` table
INSERT INTO student_bills (id, student_id, bill_id)
VALUES
(1, 101, 1),
(2, 101, 2),
(3, 102, 3),
(4, 103, 4),
(5, 103, 5),
(6, 101, 6),
(7, 102, 7),
(8, 103, 8),
(9, 101, 9),
(10, 102, 10);

-- Create `student_payment` table
CREATE TABLE student_payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    payment_date DATE NOT NULL,
    student_id INT NOT NULL,
    bill_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (bill_id) REFERENCES bills(id)
);

-- Insert sample data into `student_payment` table
INSERT INTO student_payment (id, amount, description, payment_date, student_id, bill_id)
VALUES
(1, 500.00, 'Payment for Electricity Bill', '2024-11-15', 101, 1),
(2, 200.00, 'Payment for Gym Membership', '2024-11-18', 101, 4),
(3, 1300.25, 'Payment for Electricity Charge', '2024-11-12', 102, 6),
(4, 900.50, 'Payment for Water Supply Bill', '2024-11-16', 102, 7),
(5, 2700.00, 'Payment for Fitness Club Subscription', '2024-11-26', 103, 9),
(6, 5500.25, 'Payment for Health Insurance Premium', '2024-12-01', 103, 10);

-- Confirm successful script execution
SELECT 'Database setup complete!' AS message;
