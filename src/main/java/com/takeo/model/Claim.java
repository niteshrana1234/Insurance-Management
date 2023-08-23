package com.takeo.model;



public class Claim {
    private String customerId;

    private String policyNumber;
    private String claimNumber;
    private String dateFilled;
    boolean claimStatus = false;

    public Claim(String customerId, String policyNumber, String dateFilled, boolean claimStatus) {
        this.customerId = customerId;
        this.policyNumber = policyNumber;
        this.dateFilled = dateFilled;
        this.claimStatus = claimStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    public boolean isClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(boolean claimStatus) {
        this.claimStatus = claimStatus;
    }
}
