package com.wsc.dto;

/**
 * Created by wsc on 17-2-14.
 */
public class Register {
    public String mail;
    public String password;

    public Register(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Register() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Register{" +
                "mail='" + mail + '\'' +
                ", password=*****'"  + '\'' +
                '}';
    }
}
