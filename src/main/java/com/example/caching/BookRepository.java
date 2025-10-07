package com.example.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Cacheable("books")
    List<Book> findByTitle(String title);

    @Cacheable("books")
    List<Book> findByIsbn(String isbn);  // Cambié a List<Book>

}
