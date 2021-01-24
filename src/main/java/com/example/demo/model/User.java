package com.example.demo.model;



public class User {

    int USER_ID;
    String USERNAME;
    String PASSWORD;
    String ROLE;
    int ENABLED;
    int PERSON_ID;

    public User() {
    }

    public User(int USER_ID, String USERNAME, String password, String ROLE, int ENABLED, int PERSON_ID) {
        this.USER_ID = USER_ID;
        this.USERNAME = USERNAME;
        this.PASSWORD = password;
        this.ROLE = ROLE;
        this.ENABLED = ENABLED;
        this.PERSON_ID = PERSON_ID;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void setPassword(String password) {
        this.PASSWORD = password;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public int getENABLED() {
        return ENABLED;
    }

    public void setENABLED(int ENABLED) {
        this.ENABLED = ENABLED;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }
}
