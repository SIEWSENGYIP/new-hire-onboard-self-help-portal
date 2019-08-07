package com.example.newhireonboardselfhelpportal.repositories;


import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByManagerId(Long managerId);

    List<User> findByNtName(String userName);
    
}