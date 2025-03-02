package com.Library_management_system.model;

public class User {

    private int userId;
    private String username;
    private String contactInfo;
    private String type;

    public User() {
    }
    public User(int userId, String username, String contactInfo, String type) {
        this.userId = userId;
        this.username = username;
        this.contactInfo = contactInfo;
        this.type = type;
    }

    public User(String type, String contactInfo, String username) {
        this.type = type;
        this.contactInfo = contactInfo;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
