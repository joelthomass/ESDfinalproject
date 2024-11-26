package com.example.billhistory.service;

import com.example.billhistory.entity.Bills;
import com.example.billhistory.entity.StudentBills;
import com.example.billhistory.exception.BillNotFoundException;
import com.example.billhistory.repository.BillsRepository;
import com.example.billhistory.repository.StudentBillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private BillsRepository billsRepository;

    @Autowired
    private StudentBillsRepository studentBillsRepository;

    // Existing method to get all bills
    public List<Bills> getAllBills() {
        return billsRepository.findAll();
    }

    // Existing method to get a bill by ID
    public Bills getBillById(Long id) {
        return billsRepository.findById(id)
                .orElseThrow(() -> new BillNotFoundException(id));
    }

    // New method to get bills by studentId
    public List<Bills> getBillsByStudentId(Long studentId) {
        // Fetch all student bills associated with the studentId
        List<StudentBills> studentBills = studentBillsRepository.findByStudentId(studentId);

        // If no student bills are found, return an empty list
        if (studentBills.isEmpty()) {
            return List.of();  // Or you could throw an exception here if needed
        }

        // Map the student bills to their corresponding bills
        return studentBills.stream()
                .map(StudentBills::getBill)  // Extract the Bills object from StudentBills
                .collect(Collectors.toList());
    }
}
