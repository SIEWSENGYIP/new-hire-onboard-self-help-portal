package com.example.newhireonboardselfhelpportal.repositories;


import com.example.newhireonboardselfhelpportal.entities.Checklist;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ChecklistRepository
 */
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {


    
}