package com.jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwt.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	@Query(value = "select * from User u where u.email_id=:emailId and u.password=:password", nativeQuery = true)
	public User getAuthorizedUser(String emailId, String password);
		// TODO Auto-generated method stub
		
	
	

}
