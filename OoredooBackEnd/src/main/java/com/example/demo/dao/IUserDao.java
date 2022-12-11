package com.example.demo.dao;

import java.util.List;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, String>{

	@Query("select u from User u where u.username like %?1 ")
	User findByUsername(String username);
	@Query("select u.prenom ,u.nom from User u join Coursier C on u.cin=C.cinCoursier ")
	List<String> findCoursier();
	/*@Query("select u from User u where u.role like 'Coursier'")
	List<User> findUserByRole();*/
}
