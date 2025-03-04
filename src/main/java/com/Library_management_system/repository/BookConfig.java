package com.Library_management_system.repository;

import com.Library_management_system.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner1(BookRepository bookRepository) {
        return args -> {
            Book book = new Book(
                    "Atomic habits",
                    "James Clear",
                    true
            );
            Book book1 = new Book(
                    "12 rules of life",
                    "Jordan Peterson",
                    true
            );
            bookRepository.saveAll(List.of(book,book1));
        };
    }
}
