package com.lms.lms.repository;

import com.lms.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<User, Long> {

}
