package com.example.customerRM.enumeration;

public enum CustomerStatus {
    LEAD("Lead"),
    PROSPECT("Prospect"),
    CUSTOMER("Customer");

    private final String status;
    CustomerStatus(String status){
        this.status = status;
    }

    public String getCustomerStatus(){
        return this.status;
    }
}
