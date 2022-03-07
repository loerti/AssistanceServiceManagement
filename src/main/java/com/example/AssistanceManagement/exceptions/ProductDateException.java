package com.example.AssistanceManagement.exceptions;

public class ProductDateException extends Exception {
    public ProductDateException() {
        super("The expiry date can not be before purchase date");
    }
}
