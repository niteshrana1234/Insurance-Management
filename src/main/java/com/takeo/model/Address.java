package com.takeo.model;

public class Address {
    private int buildingNumber;
    private String street;
    private String state;
    private int postalCode;
    private String city;
    private String country;


    public Address(int buildingNumber, String street, String state, int postalCode, String city, String country) {

        this.street = street;
        this.postalCode = postalCode;
        this.buildingNumber = buildingNumber;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
