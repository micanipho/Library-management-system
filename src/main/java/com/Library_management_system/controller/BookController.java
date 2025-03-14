package com.Library_management_system.controller;

import com.Library_management_system.model.Book;
import com.Library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lms/api/v1/books")
public class BookController {

        private final BookService bookService;

        @Autowired
        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @GetMapping
        @PreAuthorize("hasAuthority('book:read')")
        public List<Book> getBooks() {
            return bookService.getBooks();
        }

        @GetMapping(path = "search")
        @PreAuthorize("hasAuthority('book:read')")
        public Book searchBook(@RequestParam("title") String title,
                           @RequestParam("author") String author) {
            return bookService.searchBook(title, author);
        }
        @GetMapping(path = "{bookId}")
        @PreAuthorize("hasAuthority('book:read')")
        public Book getBookById(@PathVariable("bookId") Long bookId) {
            return bookService.getBook(bookId);
        }

        @PostMapping
        @PreAuthorize("hasAuthority('book:write')")
        public void addBook(@RequestBody Book book) {
            bookService.addNewBook(book);
        }

        @PostMapping(path = "borrow")
        @PreAuthorize("hasAuthority('book:read')")
        public void borrowBook(@RequestBody Book book) {
            bookService.borrowBook(book);
        }

        @PostMapping(path = "return")
        @PreAuthorize("hasAuthority('book:read')")
        public void returnBook(@RequestBody Book book) {
            bookService.returnBook(book);
        }

        @DeleteMapping(path = "{bookId}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public void deleteBook(@PathVariable("bookId") Long bookId) {
            bookService.deleteBook(bookId);
        }
    }
