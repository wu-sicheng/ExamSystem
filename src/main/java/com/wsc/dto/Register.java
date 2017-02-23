package com.wsc.dto;

/**
 * Created by wsc on 17-2-14.
 */
public class Register {
    public String mail;
    public String password;
    public String role;

    public Register(String mail, String password,String role) {
        this.mail = mail;
        this.password = password;
        this.role=role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Register{" +
                "mail='" + mail + '\'' +
                ", password=*****'"  + '\'' +
                '}';
    }
}
