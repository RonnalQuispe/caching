package com.example.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        logger.info("Saving books...");
        bookRepository.save(new Book("isbn-1234", "Java Basics"));
        bookRepository.save(new Book("isbn-4567", "Spring Boot Guide"));

        logger.info("Fetching from DB...");
        List<Book> books = bookRepository.findByIsbn("isbn-1234");
        for (Book book : books) {
            logger.info(book.toString());
        }
    }
}
