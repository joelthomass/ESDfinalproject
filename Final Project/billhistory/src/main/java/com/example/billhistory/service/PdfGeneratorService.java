package com.example.billhistory.service;

import com.example.billhistory.entity.StudentPayment;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PdfGeneratorService {

    public byte[] generatePaymentHistoryPdf(List<StudentPayment> payments) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(out);
            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(new com.itextpdf.kernel.pdf.PdfDocument(writer));

            // Load the Helvetica Bold font
            PdfFont boldFont = PdfFontFactory.createFont("Helvetica-Bold");

            // Add Title to PDF with bold font
            document.add(new Paragraph(new Text("Payment Receipt").setFont(boldFont).setFontSize(18)));

            // Create the table with 5 columns: Payment ID, Description, Amount, Payment Date, and Bill ID
            Table table = new Table(5);
            table.addCell("Payment ID");
            table.addCell("Description");
            table.addCell("Amount");
            table.addCell("Payment Date");
            table.addCell("Bill ID");

            // Initialize total amount as BigDecimal for accurate calculation
            BigDecimal totalAmountPaid = BigDecimal.ZERO;

            // Populate the table with data from the payments
            for (StudentPayment payment : payments) {
                table.addCell(String.valueOf(payment.getId()));
                table.addCell(payment.getDescription());
                table.addCell(String.valueOf(payment.getAmount()));
                table.addCell(payment.getPaymentDate().toString());
                table.addCell(String.valueOf(payment.getBill().getId()));

                // Add the payment amount to the total using BigDecimal
                totalAmountPaid = totalAmountPaid.add(payment.getAmount());
            }

            document.add(table);

            // Add the total amount paid at the bottom of the PDF
            document.add(new Paragraph("Total Paid: $" + totalAmountPaid.setScale(2, BigDecimal.ROUND_HALF_UP))
                    .setFont(boldFont).setFontSize(16));

            document.close();
            return out.toByteArray(); // Return the PDF as a byte array
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}
