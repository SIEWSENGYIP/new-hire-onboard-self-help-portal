
package com.example.newhireonboardselfhelpportal.controllers;

import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.User;
import com.example.newhireonboardselfhelpportal.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/users", produces="application/json")
    public List<User> displayUsers() {
        return userRepository.findAll();
    }

}