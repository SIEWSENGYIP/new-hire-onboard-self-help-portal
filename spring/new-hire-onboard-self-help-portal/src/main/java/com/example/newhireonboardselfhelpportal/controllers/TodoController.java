
package com.example.newhireonboardselfhelpportal.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.Todo;
import com.example.newhireonboardselfhelpportal.entities.UserTodo;
import com.example.newhireonboardselfhelpportal.repositories.TodoRepository;
import com.example.newhireonboardselfhelpportal.repositories.UserTodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserTodoRepository userTodoRepository;

    @GetMapping(value="/todos", produces="application/json")
    public List<Todo> displayTodos() {
        return todoRepository.findAll();
    }

    @GetMapping(value="/todos/{id}", produces="application/json")
    public Todo displayTodo(@PathVariable("id") Long id) {
        return todoRepository.findById(id).orElse(new Todo());
    }

    @PostMapping(value="/todos/{id}")
    public UserTodo updateUserTodo(@PathVariable("id") Long id) {
        UserTodo existingUserTodo = userTodoRepository.findById(id).orElse(new UserTodo());
        
        if (existingUserTodo.getId() != null) {
            existingUserTodo.setStatus(true);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            existingUserTodo.setCompletedDate(dateFormat.format(new Date()));
            System.out.println("");
            userTodoRepository.save(existingUserTodo);
        }
        return existingUserTodo;
    }

}