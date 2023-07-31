package com.example.customerRM.enumeration;

public enum Challenges {
    Storage("Storage"),
    Capital("Capital"),
    Quality("Quality"),
    Inconsistent_Supply("Inconsistent_Supply");

    private final String challenges;

    Challenges (String challenges){
        this.challenges = challenges;
    }

    public String getChallenges(){
        return this.challenges;
    }
}
