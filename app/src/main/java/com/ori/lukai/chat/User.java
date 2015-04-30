package com.ori.lukai.chat;

import java.io.Serializable;

/**
 * Created by lukai on 4/16/2015.
 */
public class User implements Serializable {
    private int account;
    private String password;
    private String operation;

    public User(int a, String p){
        this.account = a;
        this.password = p;
    }

    public User(){}

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


}
