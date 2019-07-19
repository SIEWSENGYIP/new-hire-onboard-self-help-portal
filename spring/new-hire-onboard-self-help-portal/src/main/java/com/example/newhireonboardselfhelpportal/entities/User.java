package com.example.newhireonboardselfhelpportal.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "user_role")
    private String userRole;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<UserTodo> userTodos;

    public List<CombinedUserTodo> getCombinedUserTodos() {
        ArrayList<CombinedUserTodo> combinedUserTodos = new ArrayList<>();

        for (UserTodo userTodo : this.userTodos) {
            CombinedUserTodo x = new CombinedUserTodo(userTodo);
            combinedUserTodos.add(x);
        }
        return combinedUserTodos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBadgeId() {
        return this.badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }

    public String getNtName() {
        return this.ntName;
    }

    public void setNtName(String ntName) {
        this.ntName = ntName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getManagerId() {
        return this.managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Set<UserTodo> getUserTodos() {
        return this.userTodos;
    }

    public void setUserTodos(Set<UserTodo> userTodos) {
        this.userTodos = userTodos;
    }
    

}