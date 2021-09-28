package com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.model.User;
import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.service.UserServiceImpl;





public class UserController {
	@Autowired
    private UserServiceImpl service;
	
	@GetMapping("/users")
	public List<User> list(){
		return service.getAll();
	}
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> get(@PathVariable Integer userid){
		try {
			User user=service.getById(userid);
		    return new ResponseEntity<User>(user,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
//	@GetMapping("/users/getbyage/{age}")
//	public ResponseEntity<List<User>> getuserbyage(@PathVariable Integer age){
//		 System.out.println("age"+age);
//		    return new ResponseEntity<>(service.getuserbyage(age),HttpStatus.OK);
//		
//	}
	
	@PostMapping("/useradd")
	public void add(@RequestBody User user) {
		service.save(user);
	}
	@PutMapping("/edituser/{userid}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer userid) {
	    try {
	        User existuser = service.getById(userid);
	        System.out.println( existuser.getAddress());
	        existuser.setName(user.getName());
	        existuser.setAddress(user.getAddress());
	        existuser.setAge(user.getAge());
	        existuser.setEmail(user.getEmail());
	        existuser.setNic(user.getNic());
	        existuser.setPhonenumber(user.getPhonenumber());
	        existuser.setUsername(user.getUsername());
	        existuser.setPassword(user.getPassword());
	        service.save(existuser);
	        return new ResponseEntity<User>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }      
	}
	@DeleteMapping("/deluser/{userid}")
	public void delete(@PathVariable Integer userid) {
	    service.delete(userid);
	}
	
}