package com.lms.lms.controller;

import com.lms.lms.model.Admin;
import com.lms.lms.model.dto.CreateUserRequestDto;
import com.lms.lms.service.AdminService;
import com.lms.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    @Autowired
    public AdminController( AdminService adminService, UserService userService){
        this.adminService = adminService;
        this.userService = userService;
    }

    @PostMapping(value = "/create/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAdmin(@PathVariable String username){
        adminService.createAdmin(username);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/deactivate/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deactivateAdmin(@PathVariable String username){
        adminService.deactivateAdmin(username);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> admins = adminService.getAdmins();

        return new ResponseEntity<>(admins, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/add_user", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        userService.createStudent(createUserRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
