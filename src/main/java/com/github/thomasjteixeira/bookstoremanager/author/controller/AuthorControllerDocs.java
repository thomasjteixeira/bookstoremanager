package com.github.thomasjteixeira.bookstoremanager.author.controller;

import com.github.thomasjteixeira.bookstoremanager.author.dto.AuthorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Authors management")
public interface AuthorControllerDocs {

    @ApiOperation(value = "Author creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success author creation"),
            @ApiResponse(code = 400, message = "Missing required field, wrong field range value or author already registered on system")
    })
    AuthorDTO create(AuthorDTO authorDTO);
}
