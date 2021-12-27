package com.github.thomasjteixeira.bookstoremanager.author.builder;

import com.github.thomasjteixeira.bookstoremanager.author.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Thomas Jefferson";

    @Builder.Default
    private final int age = 30;

    public AuthorDTO buildAuthorDTO(){
        return new AuthorDTO(id, name, age);
    }
}
