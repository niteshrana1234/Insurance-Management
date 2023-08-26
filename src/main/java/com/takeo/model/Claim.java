package com.takeo.model;


public class Claim {
    //Declaring variable
    private int customerId;
    private String policyNumber;
    private String claimNumber;
    private String dateFilled;

    private int claimAmount;
    boolean claimStatus = false;

    //Default constructor
    public Claim() {
    };
//Parameterized constructor
    public Claim(int customerId, String policyNumber, int claimAmount, String dateFilled, boolean claimStatus) {
        this.customerId = customerId;
        this.policyNumber = policyNumber;
        this.dateFilled = dateFilled;
        this.claimStatus = claimStatus;
        this.claimAmount = claimAmount;
    }

    //Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDateFilled() {
        return dateFilled;
    }

    public void setDateFilled(String dateFilled) {
        this.dateFilled = dateFilled;
    }

    public boolean getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(boolean claimStatus) {
        this.claimStatus = claimStatus;
    }

    public int getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(int claimAmount) {
        this.claimAmount = claimAmount;
    }
}
