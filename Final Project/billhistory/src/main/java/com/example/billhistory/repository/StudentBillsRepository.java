package com.example.billhistory.repository;

import com.example.billhistory.entity.StudentBills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentBillsRepository extends JpaRepository<StudentBills, Long> {
    List<StudentBills> findByStudentId(Long studentId);
}
