package com.spring.rest.springRestApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.springRestApp.entity.User;

@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends CrudRepository<User, Long> {	

}
