package com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.repository;



import com.example.thymleaf_Security_Registration.thymleaf_Security_Registration.model.User;



import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    
   // public List<RequestAcc> getJoinInformation();
	//@Query("SELECT new com.example.usermanagement.dto.RequestAcc(u.name,a.accnumber,SUM(a.amount)) FROM User u Join u.accounts a",)
//	@Query(value = "SELECT SUM(a.amount),u.name FROM Account a,User u where u.id=a.up_fk group by u.name ", nativeQuery = true)
//	public Float getAccAmount();
	//, nativeQuery = true
//	@Query(value = "SELECT SUM(a.amount),u.name FROM Account a,User u where u.id=a.up_fk ", nativeQuery = true)
//	public Float getAccAmount();
//	@Query(value="select * from user u where u.age=?1",nativeQuery = true) 
//	public List<User> getuserbyage(Integer age);
//	
//	@Query(value="select u.id from user u where u.nic=?1",nativeQuery = true)
//	public String getByNic(String nic);
//	@Query(value="select * from user u where u.id=?1",nativeQuery = true) 
//	public List<User> getuseracc(Integer id);
//	
//	@Query(value="select * from account a where a.type=?1",nativeQuery = true) 
//	public List<Account> getaccountbytype(String type);
//	
//	//@Query(value="select * from account a ,where a.type=?1") 
//	//public List<Account> getaccountbytype(String type);
//	
//	
//	
	
}
