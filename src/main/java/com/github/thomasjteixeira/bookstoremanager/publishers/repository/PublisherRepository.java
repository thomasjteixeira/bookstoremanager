package com.github.thomasjteixeira.bookstoremanager.publishers.repository;

import com.github.thomasjteixeira.bookstoremanager.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
