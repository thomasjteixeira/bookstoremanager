package com.github.thomasjteixeira.bookstoremanager.author.service;

import com.github.thomasjteixeira.bookstoremanager.author.dto.AuthorDTO;
import com.github.thomasjteixeira.bookstoremanager.author.entity.Author;
import com.github.thomasjteixeira.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.github.thomasjteixeira.bookstoremanager.author.mapper.AuthorMapper;
import com.github.thomasjteixeira.bookstoremanager.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO){
        verifyIfExists(authorDTO.getName());
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createAuthor = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createAuthor);
    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
                .ifPresent(author -> {throw new AuthorAlreadyExistsException(authorName);});
    }
}
