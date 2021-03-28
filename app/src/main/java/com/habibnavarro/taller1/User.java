package com.habibnavarro.taller1;

public class User {
    String username;
    String password;
    String fisrt_name;
    String last_name;

    public User(String username, String password, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.fisrt_name = first_name;
        this.last_name = last_name;
    }



    public boolean validate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
