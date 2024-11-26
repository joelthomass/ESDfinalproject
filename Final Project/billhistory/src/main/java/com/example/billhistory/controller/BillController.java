package com.example.billhistory.controller;

import com.example.billhistory.entity.Bills;
import com.example.billhistory.exception.BillNotFoundException;
import com.example.billhistory.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/bills")
    public List<Bills> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<?> getBillById(@PathVariable Long id) {
        try {
            Bills bill = billService.getBillById(id);
            return ResponseEntity.ok(bill);
        } catch (BillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/bills/student/{studentId}")
    public ResponseEntity<?> getBillsByStudentId(@PathVariable Long studentId) {
        List<Bills> bills = billService.getBillsByStudentId(studentId);
        if (bills.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bills found for student with ID: " + studentId);
        }
        return ResponseEntity.ok(bills);
    }
}
