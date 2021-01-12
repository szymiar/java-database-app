package com.example.demo.dao;

import com.example.demo.model.Login;

public class LoginsDAO {

    public LoginsDAO(){

    }


    public boolean verify(Login login){
        if(login.getLogin()== "admin" && login.getPassword()=="admin"){
            return true;
        }
        return false;
    }


}
