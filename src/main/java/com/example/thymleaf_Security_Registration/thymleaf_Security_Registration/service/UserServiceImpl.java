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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    //filterable injection
	@Autowired
	private UserRepository userrepo;
	
	//@Autowired quickly inject
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userrepo = userRepository;
		// TODO Auto-generated constructor stub
	}
	
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getId(), 
				registrationDto.getNic(),registrationDto.getName(),registrationDto.getUsername(),
				passwordEncoder.encode(registrationDto.getPassword()),
				registrationDto.getAge(),registrationDto.getAddress(),registrationDto.getEmail(),
				registrationDto.getPhonenumber(), 
				
				 Arrays.asList(new Role("ROLE_USER")));
		
		return userrepo.save(user);
	}
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        //call repository findByEmail(username) method to pass email
		 
		    System.out.print(username);
	        User user = userrepo.findByEmail(username);
	        System.out.print(user.getAddress());
	        System.out.print(user.getAddress());
	        //if email not in db generate UsernameNotFoundException
	        if(user == null) {
	            throw new UsernameNotFoundException("wrong check.");
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

	public List<User> getAll() {
		return userrepo.findAll();
	}

	public User getById(Integer id) {
		return userrepo.findById(id).get();
	}
	
	public void save(User user) {
        userrepo.save(user);
    }
	
	 public void delete(Integer id) {
	        userrepo.deleteById(id);
	    }
	 public User Updateuser(User user,Integer id) {
		 //check user
	        return null;
	    }
//	 public List<User> getuserbyage(Integer age) {
//		    System.out.println("age"+age);
//			return userrepo.getuserbyage(age);
//		}
//		
////		 public List<Account> getaccbytype(String type) {
////			    System.out.println("age"+type);
////				return userrepo.getaccountbytype(type);
////			}
//
//		public String getByNic(String nic) {
//			// TODO Auto-generated method stub
//			 System.out.println("nic"+nic);
//			return userrepo.getByNic(nic);
//		}
		
}
