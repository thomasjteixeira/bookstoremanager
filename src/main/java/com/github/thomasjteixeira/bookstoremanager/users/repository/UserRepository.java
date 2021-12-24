package com.github.thomasjteixeira.bookstoremanager.users.repository;

import com.github.thomasjteixeira.bookstoremanager.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
