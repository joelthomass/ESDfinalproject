package com.example.studentbillsystem.repository;

import com.example.studentbillsystem.model.StudentBills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Define the repository interface for Student_Bills
public interface Student_BillsRepository extends JpaRepository<StudentBills, Long> {

    // Method to fetch all the bills for a specific student
    List<StudentBills> findByStudentId(Long studentId);
}
