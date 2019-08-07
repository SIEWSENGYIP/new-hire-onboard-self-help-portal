
package com.example.newhireonboardselfhelpportal.controllers;

import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.CombinedUserTodo;
import com.example.newhireonboardselfhelpportal.entities.Team;
import com.example.newhireonboardselfhelpportal.entities.Todo;
import com.example.newhireonboardselfhelpportal.entities.User;
import com.example.newhireonboardselfhelpportal.entities.UserTodo;
import com.example.newhireonboardselfhelpportal.repositories.TeamRepository;
import com.example.newhireonboardselfhelpportal.repositories.TodoRepository;
import com.example.newhireonboardselfhelpportal.repositories.UserRepository;
import com.example.newhireonboardselfhelpportal.repositories.UserTodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTodoRepository userTodoRepository;

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TeamRepository teamRepository;

    @GetMapping(value="/users", produces="application/json")
    public List<User> displayUsers(@RequestParam(required=false) Long managerId, @RequestParam(required=false) String userName) {
        if (managerId != null) {
            return userRepository.findAllByManagerId(managerId);
        }

        if (userName != null) {
            return userRepository.findByNtName(userName);
        }
        return userRepository.findAll();
    }

    @GetMapping(value="/users/{id}", produces="application/json")
    public User displayUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @PostMapping(value="/users/{id}/teams/{teamId}")
    public User updateUser(@PathVariable("id") Long id, @PathVariable("teamId") Long teamId) {
        User existingUser = userRepository.findById(id).orElse(new User());
        if (existingUser.getId() != null) {
            Team team = teamRepository.findById(teamId).orElse(new Team());
            if (team.getId() != null) {
                existingUser.setTeam(team);
                userRepository.save(existingUser);
            }
        }

        return existingUser;
    }

    @PostMapping(value="/users/{id}/todos/{todoId}")
    public UserTodo insertUserTodo(@RequestBody UserTodo userTodo, @PathVariable("id") Long id, @PathVariable("todoId") Long todoId){
        User existingUser = userRepository.findById(id).orElse(new User());
        if (existingUser.getId() != null) {
            Long userId = existingUser.getId();

            Todo todo = todoRepository.findById(todoId).orElse(new Todo());
            if (todo.getId() != null) {
                UserTodo existingUserTodo = userTodoRepository.findByUserIdAndTodoId(userId, todoId);

                if (existingUserTodo == null) {
                    userTodo.setUser(existingUser);
                    userTodo.setTodo(todo);
                    userTodoRepository.save(userTodo);
                }
            }
            
        }

        return userTodo;
    }
}