package com.lms.lms.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> getAllStudents(){
        return ResponseEntity.ok("jeij");
    }
}
