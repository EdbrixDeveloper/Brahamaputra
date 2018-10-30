package com.brahamaputra.mahindra.brahamaputra.Data;

public class User {

    private String userName;
    private String userEmail;
    private String userMobile;

    public User(String userName, String userEmail, String userMobile) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
}
