package com.example.demo.model;

import java.util.Date;

public class Animal {
    private int ANIMAL_ID;
    private String NAME;
    private String SPECIES;
    private String RACE;
    private String DATE_OF_BIRTH;
    private int PERSON_ID;

    public Animal() {
    }



    public Animal(int ANIMAL_ID, String NAME, String SPECIES, String RACE, String DATE_OF_BIRTH,int PERSON_ID) {
        this.ANIMAL_ID = ANIMAL_ID;
        this.NAME = NAME;
        this.SPECIES = SPECIES;
        this.RACE = RACE;
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
        this.PERSON_ID= PERSON_ID;
    }

    public int getANIMAL_ID() {
        return ANIMAL_ID;
    }

    public void setANIMAL_ID(int ANIMAL_ID) {
        this.ANIMAL_ID = ANIMAL_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSPECIES() {
        return SPECIES;
    }

    public void setSPECIES(String SPECIES) {
        this.SPECIES = SPECIES;
    }

    public String getRACE() {
        return RACE;
    }

    public void setRACE(String RACE) {
        this.RACE = RACE;
    }

    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }

    public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

}
