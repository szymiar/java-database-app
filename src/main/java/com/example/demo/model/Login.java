package com.example.demo.model;

public class Login {

    private String password;
    private String login;

    public Login() {
    }

    public Login(String login, String password) {
      this.password=password;
      this.login=login;
    }

  public String getPassword(){return password;}
  public void setPassword(String password){this.password=password;}

    public String getLogin(){return login;}
    public void setLogin(String login){this.login=login;}
}

