
package com.example.newhireonboardselfhelpportal.controllers;

import java.util.List;

import com.example.newhireonboardselfhelpportal.entities.Checklist;
import com.example.newhireonboardselfhelpportal.repositories.ChecklistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class ChecklistController {

    @Autowired
    ChecklistRepository checklistRepository;

    @GetMapping(value="/checklists", produces="application/json")
    public List<Checklist> displayChecklists() {
        return checklistRepository.findAll();
    }

}