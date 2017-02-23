package com.wsc.dto.login;

/**
 * Created by wsc on 17-2-14.
 */
public class LoginDTO {
    private String account;
    private String password;
    private String role;

    public LoginDTO(String account, String password, String role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public LoginDTO() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
        return "LoginDTO{" +
                "account='" + account + '\'' +
                ", password=*******'" +  '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
