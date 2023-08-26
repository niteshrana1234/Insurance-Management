package com.takeo.model;

import com.takeo.main.PolicyManagementModule;

import java.util.ArrayList;
import java.util.List;

public class Customer {
   //Declaring variable
    private String fullName;
    private int customerId;
    private static int nextId = 1;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;
    private Address address;
    private String password;


    //Default constructor
    public Customer() {
    }

    //Parameterized constructor

    public Customer(String fullName, String phoneNumber,String emailAddress, String dateOfBirth, Address address,String password) {
        this.customerId = nextId++;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
        this.emailAddress = emailAddress;

    }

    //Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


