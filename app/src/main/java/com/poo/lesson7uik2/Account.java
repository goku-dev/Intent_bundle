package com.poo.lesson7uik2;

import java.io.Serializable;

public class Account implements Serializable {
    private String userName , passWord;

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
