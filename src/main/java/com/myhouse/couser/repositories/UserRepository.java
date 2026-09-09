package com.myhouse.couser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhouse.couser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
