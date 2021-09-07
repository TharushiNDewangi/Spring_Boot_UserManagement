package com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.repository;

import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
