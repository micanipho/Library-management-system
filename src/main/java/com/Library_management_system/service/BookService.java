package com.Library_management_system.service;

import com.Library_management_system.model.Book;
import com.Library_management_system.model.User;
import com.Library_management_system.repository.BookRepository;
import com.Library_management_system.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Autowired
    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
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

    public List<Book> searchBook(String title, String author) {
        if (title != null && author != null) {
            return bookRepository.findByTitleAndAuthor(title, author).map(List::of)
                    .orElseThrow(() -> new IllegalStateException("Book not found"));
        } else if (title != null) {
            return bookRepository.findBookByTitle(title).map(List::of).orElseThrow(
                    () -> new IllegalStateException("Book with title "+ title +" not found")
            );
        } else if (author != null) {
            return bookRepository.findBookByAuthor(author).map(List::of).orElseThrow(
                    () -> new IllegalStateException("Book with author "+ author +" not found")
            );
        } else {
            return bookRepository.findAll();
        }
    }


    @Transactional
    public void borrowBook(Book book, String email) {
        Book bookToBorrow = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor())
                .orElseThrow(() -> new IllegalStateException("Book not found"));

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("User with email " + email + " not found")
        );

        if (!bookToBorrow.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed");
        }


        bookToBorrow.setAvailable(false);
        bookToBorrow.setDateBorrowed(LocalDate.now());
        bookToBorrow.setDateReturned(LocalDate.now().plusWeeks(1));
        user.addBorrowedBooks(bookToBorrow);
    }

    @Transactional
    public void returnBook(Book book, String email) {
        Book bookToReturn = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor())
                .orElseThrow(() -> new IllegalStateException("Book not found"));

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("User with email " + email + " not found")
        );

        if (bookToReturn.isAvailable()) {
            throw new IllegalStateException("Book is already returned");
        }


        user.removeBorrowedBook(bookToReturn);
        bookToReturn.setAvailable(true);
        bookToReturn.setDateBorrowed(null);
        bookToReturn.setDateReturned(null);
    }
}
