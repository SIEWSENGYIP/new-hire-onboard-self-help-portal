package com.example.newhireonboardselfhelpportal.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Checklist
 */
@Entity(name = "checklists")
public class Checklist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item")
    private String item;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "url")
    private String url;

    @Column(name = "reference_doc")
    private String reference_doc;

    @JsonManagedReference
    @OneToMany(mappedBy = "checklists")
    private Set<UserChecklist> userChecklists;

    @JsonBackReference
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name="team_checklists", 
        joinColumns={@JoinColumn(name="checklist_id")}, 
        inverseJoinColumns={@JoinColumn(name="team_id")}
    )
    private Set<Team> teams;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReference_doc() {
        return this.reference_doc;
    }

    public void setReference_doc(String reference_doc) {
        this.reference_doc = reference_doc;
    }

    public Set<UserChecklist> getUserChecklists() {
        return this.userChecklists;
    }

    public void setUserChecklists(Set<UserChecklist> userChecklists) {
        this.userChecklists = userChecklists;
    }

    public Set<Team> getTeams() {
        return this.teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

}