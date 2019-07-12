package com.example.newhireonboardselfhelpportal.repositories;


import com.example.newhireonboardselfhelpportal.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {


    
}