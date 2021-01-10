package com.example.demo.model;

public class Address {
    private int ADDRESS_ID;
    private String STREET;
    private String APT_NUMBER;
    private String CODE;
    private String CITY;

    public Address() {
    }

    public Address(int ADDRESS_ID, String STREET, String APT_NUMBER, String CODE, String CITY) {
        this.ADDRESS_ID = ADDRESS_ID;
        this.STREET = STREET;
        this.APT_NUMBER = APT_NUMBER;
        this.CODE = CODE;
        this.CITY = CITY;
    }

    public int getADDRESS_ID() {
        return ADDRESS_ID;
    }

    public void setADDRESS_ID(int ADDRESS_ID) {
        this.ADDRESS_ID = ADDRESS_ID;
    }

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    public String getAPT_NUMBER() {
        return APT_NUMBER;
    }

    public void setAPT_NUMBER(String APT_NUMBER) {
        this.APT_NUMBER = APT_NUMBER;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }
}
