
package com.example.newhireonboardselfhelpportal.controllers;

import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.Todo;
import com.example.newhireonboardselfhelpportal.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping(value="/todos", produces="application/json")
    public List<Todo> displayTodos() {
        return todoRepository.findAll();
    }

}