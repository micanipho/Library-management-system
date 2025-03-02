package com.Library_management_system.repository;

import com.Library_management_system.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
            bookRepository.save(book);
        };
    }
}
