package com.example.fitTrace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.fitTrace.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User , Long>{
	
 

}
