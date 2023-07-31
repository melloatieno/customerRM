package com.example.customerRM.enumeration;

public enum Category {
    Family("Family"),
    MicroEnterprise("MicroEnterprise"),
    SmallEnterprise("SmallEnterprise"),
    MediumEnterprise("MediumEnterprise"),
    LargeEnterprise("LargeEnterprise");

    private final String category;

    Category(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
