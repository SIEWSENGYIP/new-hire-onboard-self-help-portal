package com.example.newhireonboardselfhelpportal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User
 */
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "badge_id")
    private Long badgeId;

    @Column(name = "nt_name")
    private String ntName;

    @Column(name = "email")
    private String email;

    @Column(name = "joined_date")
    private String joinedDate;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "user_role")
    private String userRole;
}