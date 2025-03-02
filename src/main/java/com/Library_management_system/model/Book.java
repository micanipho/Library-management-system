package com.Library_management_system.model;

import java.time.LocalDate;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private LocalDate date;

    public Book() {
    }

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public Book(boolean isAvailable, String author, String title, int bookId) {
        this.isAvailable = isAvailable;
        this.author = author;
        this.title = title;
        this.bookId = bookId;
    }

    public Book(int bookId, String title, String author, boolean isAvailable, LocalDate date) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.date = date;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                ", date=" + date +
                '}';
    }
}
