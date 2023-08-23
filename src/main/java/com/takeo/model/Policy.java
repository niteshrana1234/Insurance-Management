package com.takeo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Policy {
    private String policyNumber;
    private String policyType;
    private String startDate;
    private String expireDate;
    private int customerId;

    public Policy(int customerId, String policyType, String startDate, String expireDate) {
        this.policyType = policyType;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.customerId = customerId;
    }

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

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

}

