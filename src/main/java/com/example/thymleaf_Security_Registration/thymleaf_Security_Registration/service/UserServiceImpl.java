package com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.service;

import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.model.Role;
import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.model.User;
import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.repository.UserRepository;
import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    //filterable injection
    private UserRepository userRepository;

    //@Autowired quickly inject
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //constructor base injection
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        //create user object and pass data through registrationDto
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //call repository findByEmail(username) method to pass email
        User user = userRepository.findByEmail(username);
        //if email not in db generate UsernameNotFoundException
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        //if email available,that object belong to spring security ekai mehema
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                //get role to call mapRolesToAuthorities() method
                mapRolesToAuthorities(user.getRoles()));
    }

    //pass collection of roles
    ///we want to convert roles to authority
    // stream() use krala convert krnna pluwn
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        // then map role to the authority
        return roles.stream().map(role ->
                // create SimpleGrantedAuthority object (collection of objects)
                new SimpleGrantedAuthority(role.getName()))
                //collect result
                .collect(Collectors.toList());
    }

}
