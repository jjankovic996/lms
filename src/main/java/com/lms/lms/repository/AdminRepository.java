package com.lms.lms.repository;

import com.lms.lms.enums.Role;
import com.lms.lms.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findOneByUsername(String username);

    List<Admin> findByRole(Role role);
}
