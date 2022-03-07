package com.example.AssistanceManagement.exceptions;

public class RepairSheetDateException extends Exception {

    public RepairSheetDateException() {
        super("Repair Sheets can not be created before a product");
    }

}
