package com.example.billhistory.exception;

public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException(Long id) {
        super("Bill with ID " + id + " not found");
    }
}
