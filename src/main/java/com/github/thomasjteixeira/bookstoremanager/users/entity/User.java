package com.github.thomasjteixeira.bookstoremanager.users.entity;

import com.github.thomasjteixeira.bookstoremanager.books.entity.Book;
import com.github.thomasjteixeira.bookstoremanager.entity.Auditable;
import com.github.thomasjteixeira.bookstoremanager.users.enums.Gender;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Gender gender;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Book> books;
}
