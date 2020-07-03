package com.lms.lms.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;


public class CreateStudentResponse {
    private String email;
    private String  password;

    @JsonCreator
    public CreateStudentResponse(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
