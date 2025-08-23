package com.examples.exceptions;

public class CustomTestCheckedException {

    public void processTransaction(double amount) throws CustomCheckedException {
        if (amount <= 0) {
            throw new CustomCheckedException("Transaction amount must be greater than zero.");
        }
        System.out.println("Transaction processed successfully.");
    }

    public static void main(String[] args) {
        CustomTestCheckedException test = new CustomTestCheckedException();
        try {
            test.processTransaction(-1);
        } catch (CustomCheckedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// Checked Exception: Extends Exception, not RuntimeException
class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}