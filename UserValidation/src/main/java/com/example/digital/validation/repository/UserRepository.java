package com.example.digital.validation.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.digital.validation.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}