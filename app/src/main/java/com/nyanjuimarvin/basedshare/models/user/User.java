package com.nyanjuimarvin.basedshare.models.user;

import androidx.annotation.NonNull;

public class User {

    private String userName;
    private String Email;
    private String password;

    public User(String userName, String Email, String password) {
        this.userName = userName;
        this.Email = Email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
