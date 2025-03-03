package com.Library_management_system.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_user")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
    private String username;
    private String email;
    private String type;
    @OneToMany
    private List<Book> borrowedBooks;

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBooks(Book book) {
        this.borrowedBooks.add(book);
    }

    public User() {
    }
    public User(Long userId, String username, String email, String type) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.type = type;
        borrowedBooks = new ArrayList<>();
    }

    public User(String username, String email, String type) {
        this.type = type;
        this.email = email;
        this.username = username;
        borrowedBooks = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String contactInfo) {
        this.email = contactInfo;
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
                ", contactInfo='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
