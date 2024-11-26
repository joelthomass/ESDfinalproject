package com.example.billhistory.service;

import com.example.billhistory.entity.StudentPayment;
import com.example.billhistory.repository.StudentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPaymentService {

    @Autowired
    private StudentPaymentRepository studentPaymentRepository;

    public List<StudentPayment> getPaymentsByStudentId(Long studentId) {
        return studentPaymentRepository.findByStudentId(studentId);
    }

    public StudentPayment savePayment(StudentPayment studentPayment) {
        return studentPaymentRepository.save(studentPayment);
    }
}
