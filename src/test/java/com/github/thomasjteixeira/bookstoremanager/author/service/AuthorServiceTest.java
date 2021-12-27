package com.github.thomasjteixeira.bookstoremanager.author.service;

import com.github.thomasjteixeira.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.github.thomasjteixeira.bookstoremanager.author.dto.AuthorDTO;
import com.github.thomasjteixeira.bookstoremanager.author.entity.Author;
import com.github.thomasjteixeira.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.github.thomasjteixeira.bookstoremanager.author.mapper.AuthorMapper;
import com.github.thomasjteixeira.bookstoremanager.author.repository.AuthorRepository;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp(){
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
    }

    @Test
    void whenNewAuthorIsInformedThenItShouldBeCreated(){
        //given
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreateAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        //when
        Mockito.when(authorRepository.save(expectedCreateAuthor)).thenReturn(expectedCreateAuthor);
        Mockito.when(authorRepository.findByName(expectedAuthorToCreateDTO.getName())).thenReturn(Optional.empty());

        AuthorDTO createAuthorDTO = authorService.create(expectedAuthorToCreateDTO);

        //then
        assertThat(createAuthorDTO, Is.is(IsEqual.equalTo(expectedAuthorToCreateDTO)));
    }

    @Test
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown(){
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreateAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        Mockito.when(authorRepository.findByName(expectedAuthorToCreateDTO.getName()))
                .thenReturn(Optional.of(expectedCreateAuthor));

        Assertions.assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreateDTO));



    }
}
