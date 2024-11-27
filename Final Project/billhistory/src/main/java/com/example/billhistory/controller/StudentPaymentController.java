package com.example.billhistory.controller;

import com.example.billhistory.entity.StudentPayment;
import com.example.billhistory.service.PdfGeneratorService;
import com.example.billhistory.service.StudentPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentPaymentController {

    @Autowired
    private StudentPaymentService studentPaymentService;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    @GetMapping("/student/payments/{studentId}")
    public List<StudentPayment> getPaymentsByStudentId(@PathVariable Long studentId) {
        return studentPaymentService.getPaymentsByStudentId(studentId);
    }

    @GetMapping("student/payments/{studentId}/pdf")
    public ResponseEntity<byte[]> downloadPaymentHistoryPdf(@PathVariable Long studentId) {
        List<StudentPayment> payments = studentPaymentService.getPaymentsByStudentId(studentId);
        byte[] pdfContent = pdfGeneratorService.generatePaymentHistoryPdf(payments);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "payment_history.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContent);
    }
}