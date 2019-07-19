package com.example.newhireonboardselfhelpportal.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy="team")
    private Set<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private Set<TeamTodo> teamTodos;

    // @JsonManagedReference
    // @ManyToMany(mappedBy = "teams")
    // private Set<Todo> todos;

    public List<CombinedTeamTodo> getCombinedTeamTodos() {
        ArrayList<CombinedTeamTodo> combinedTeamTodos = new ArrayList<>();

        for (TeamTodo teamTodo : this.teamTodos) {
            CombinedTeamTodo x = new CombinedTeamTodo(teamTodo);
            combinedTeamTodos.add(x);
        }
        return combinedTeamTodos;
    }

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

    public Set<TeamTodo> getTeamTodos() {
        return this.teamTodos;
    }

    public void setTeamTodos(Set<TeamTodo> teamTodos) {
        this.teamTodos = teamTodos;
    }
   

}