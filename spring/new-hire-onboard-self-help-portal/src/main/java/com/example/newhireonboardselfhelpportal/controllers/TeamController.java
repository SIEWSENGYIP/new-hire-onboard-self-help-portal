
package com.example.newhireonboardselfhelpportal.controllers;

import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.Team;
import com.example.newhireonboardselfhelpportal.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping(value="/teams", produces="application/json")
    public List<Team> displayTeams() {
        return teamRepository.findAll();
    }

}