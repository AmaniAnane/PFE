package com.example.demo.dao;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.User;


public interface UserRespository extends JpaRepository<User, Integer>{
	
	 @Query(" select u from User u " +
	            " where u.login_User = ?1")
	    Optional<User> findUserWithLogin(String login_User);
	
//	Optional<Users> findById(Long id_User);
	User user=Singleton.getInstance().getUser();
	
}
