package com.example.newhireonboardselfhelpportal.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Team
 */
@Entity(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String ntName;

    @JsonManagedReference
    @OneToMany(mappedBy="team")
    private Set<User> users;

    @JsonManagedReference
    @ManyToMany(mappedBy = "teams")
    private Set<Todo> todos;



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNtName() {
        return this.ntName;
    }

    public void setNtName(String ntName) {
        this.ntName = ntName;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Todo> getTodos() {
        return this.todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }
   

}