package com.example.newhireonboardselfhelpportal.repositories;


import com.example.newhireonboardselfhelpportal.entities.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TodoRepository
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {


    
}