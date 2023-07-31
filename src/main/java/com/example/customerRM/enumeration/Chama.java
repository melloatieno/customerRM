package com.example.customerRM.enumeration;

public enum Chama {
    YES("YES"),
    NO("NO");

    private final String chama;
    Chama(String chama){
        this.chama = chama;
    }
    public String getChama(){
        return this.chama;
    }
}
