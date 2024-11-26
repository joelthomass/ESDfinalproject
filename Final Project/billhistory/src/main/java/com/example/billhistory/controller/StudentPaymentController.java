package com.example.billhistory.controller;

import com.example.billhistory.entity.StudentPayment;
import com.example.billhistory.service.StudentPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentPaymentController {

    @Autowired
    private StudentPaymentService studentPaymentService;

    @GetMapping("/student/payments/{studentId}")
    public List<StudentPayment> getPaymentsByStudentId(@PathVariable Long studentId) {
        return studentPaymentService.getPaymentsByStudentId(studentId);
    }
}
