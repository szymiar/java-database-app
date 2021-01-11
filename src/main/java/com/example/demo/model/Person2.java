package com.example.demo.model;

import java.util.Date;

public class Person2 {

    private int PERSON_ID;
    private String NAME;
    private String SURNAME;
    private Date BIRTH_DATE;
    private int ADDRESS_ID;


    public Person2() {
    }

    public Person2(int PERSON_ID, String NAME, String SURNAME, Date BIRTH_DATE, int ADDRESS_ID) {
        this.PERSON_ID = PERSON_ID;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.BIRTH_DATE = BIRTH_DATE;
        this.ADDRESS_ID = ADDRESS_ID;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public Date getBIRTH_DATE() {
        return BIRTH_DATE;
    }

    public void setBIRTH_DATE(Date BIRTH_DATE) {
        this.BIRTH_DATE = BIRTH_DATE;
    }

    public int getADDRESS_ID() {
        return ADDRESS_ID;
    }

    public void setADDRESS_ID(int ADDRESS_ID) {
        this.ADDRESS_ID = ADDRESS_ID;
    }
}
