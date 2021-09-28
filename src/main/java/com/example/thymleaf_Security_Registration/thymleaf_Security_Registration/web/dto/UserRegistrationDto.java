package com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.web.dto;

import java.util.List;




//dto object use for transfer data for server to client
//it is design pattern
public class UserRegistrationDto {
	private Integer id;
	private String nic;
	private String name;
	private String username;
	private String password;
	private Integer age;
	private String address;
	private String email;
	private String phonenumber;
	
 
	
	
	public UserRegistrationDto(Integer id, String nic, String name, String username, String password, Integer age,
			String address, String email, String phonenumber) {
		super();
		this.id = id;
		this.nic = nic;
		this.name = name;
		this.username = username;
		this.password = password;
		this.age = age;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public UserRegistrationDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	


}
