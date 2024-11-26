package com.example.billhistory.repository;

import com.example.billhistory.entity.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Long> {
    List<StudentPayment> findByStudentId(Long studentId);
}
