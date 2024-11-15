package com.example.studentbillsystem.controller;

import com.example.studentbillsystem.model.StudentBills;
import com.example.studentbillsystem.service.StudentBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentBillController {

    @Autowired
    private StudentBillService studentBillService;

    @GetMapping("/due-bills/{studentId}")
    public List<StudentBills> getDueBills(@PathVariable Long studentId) {
        return studentBillService.getDueBills(studentId);
    }
}
