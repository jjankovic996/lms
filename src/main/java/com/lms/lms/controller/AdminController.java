package com.lms.lms.controller;

import com.lms.lms.model.Admin;
import com.lms.lms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController( AdminService adminService){
        this.adminService = adminService;
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
}
