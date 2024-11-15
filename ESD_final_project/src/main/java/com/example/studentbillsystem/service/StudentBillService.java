package com.example.studentbillsystem.service;

import com.example.studentbillsystem.model.StudentBills;
import com.example.studentbillsystem.repository.Student_BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBillService {

    @Autowired
    private Student_BillsRepository studentBillsRepository;

    public List<StudentBills> getDueBills(Long studentId) {
        return studentBillsRepository.findByStudentId(studentId);
    }
}
