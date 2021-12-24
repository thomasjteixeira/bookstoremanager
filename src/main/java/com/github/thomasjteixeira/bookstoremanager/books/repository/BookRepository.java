package com.github.thomasjteixeira.bookstoremanager.books.repository;

import com.github.thomasjteixeira.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
