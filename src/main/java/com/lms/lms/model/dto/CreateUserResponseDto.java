package com.lms.lms.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;


public class CreateUserResponseDto {
    private String email;
    private String  password;

    @JsonCreator
    public CreateUserResponseDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
