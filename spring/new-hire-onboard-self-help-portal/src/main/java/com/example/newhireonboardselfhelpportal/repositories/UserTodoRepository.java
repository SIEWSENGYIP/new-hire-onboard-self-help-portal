package com.example.newhireonboardselfhelpportal.repositories;


import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.UserTodo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserTodoRepository
 */
public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
    UserTodo findByUserIdAndTodoId(Long userId, Long todoId);
}