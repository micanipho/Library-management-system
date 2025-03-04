package com.Library_management_system.controller;

import com.Library_management_system.model.Book;
import com.Library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
        public List<Book> getBooks() {
            return bookService.getBooks();
        }

        @GetMapping(path = "search")
        public List<Book> searchBook(
                @RequestParam(required = false) String title,
                @RequestParam(required = false) String author) {
            return bookService.searchBook(title, author);
        }

        @GetMapping(path = "{bookId}")
        public Book getBookById(@PathVariable("bookId") Long bookId) {
            return bookService.getBook(bookId);
        }

        @PostMapping
        public void addBook(@RequestBody Book book) {
            bookService.addNewBook(book);
        }

        @PostMapping(path = "borrow")
        public void borrowBook(@RequestBody Book book,
                               @RequestParam String email) {
            bookService.borrowBook(book, email);
        }

        @PostMapping(path = "return")
        public void returnBook(@RequestBody Book book,
                               @RequestParam String email) {
            bookService.returnBook(book, email);
        }

        @DeleteMapping(path = "{bookId}")
        public void deleteBook(@PathVariable("bookId") Long bookId) {
            bookService.deleteBook(bookId);
        }
    }
