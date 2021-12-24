package com.github.thomasjteixeira.bookstoremanager.author.repository;


import com.github.thomasjteixeira.bookstoremanager.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
