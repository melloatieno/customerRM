package com.example.customerRM.enumeration;

public enum Freezer {
    YES("YES"),
    NO("NO");

    private final String freezer;
    Freezer(String freezer){
        this.freezer = freezer;
    }
    public String getChama(){
        return this.freezer;
    }
}
