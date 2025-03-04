package com.Library_management_system.service;

import com.Library_management_system.model.Book;
import com.Library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());

        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Book already exists");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new IllegalStateException("Book with id " + bookId + " does not exist")
        );
    }

    public Book searchBook(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author).orElseThrow(
                () -> new IllegalStateException("Book with title " + title + "and author " +
                        author + " does not exist.")
        );
    }


    @Transactional
    public void borrowBook(Book book) {
        Book bookToBorrow = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor()).orElseThrow(
                () -> new IllegalStateException("Book with id " + book.getBookId() + " does not exist")
        );
        bookToBorrow.setDateBorrowed(LocalDate.now());
        bookToBorrow.setAvailable(false);
    }

    @Transactional
    public void returnBook(Book book) {
        Book bookToReturn = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor()).orElseThrow(
                () -> new IllegalStateException("Book with id " + book.getBookId() + " does not exist")
        );
        bookToReturn.setAvailable(true);


    }
}
