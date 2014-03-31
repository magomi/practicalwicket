package de.practicalwicket.model;

import java.io.Serializable;

/**
 * Created by bert
 */
public class Registration implements Serializable {


    private String email;
    private String userName;
    private String password;
    private boolean spam;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }
}
