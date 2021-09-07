package com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.service;

import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.model.User;
import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    //pass dto object
    User save(UserRegistrationDto registrationDto);

}
