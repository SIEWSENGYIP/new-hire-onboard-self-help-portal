package com.example.newhireonboardselfhelpportal.entities;

/**
 * CombinedTeamTodo
 */
public class CombinedTeamTodo {
    Long todoId;
    String item;
    String description;
    String category;
    String url;
    String referenceDoc;

    CombinedTeamTodo(TeamTodo teamTodo) {
        this.todoId = teamTodo.getTodo().getId();
        this.item = teamTodo.getTodo().getItem();
        this.description = teamTodo.getTodo().getDescription();
        this.category = teamTodo.getTodo().getCategory();
        this.url = teamTodo.getTodo().getUrl();
        this.referenceDoc = teamTodo.getTodo().getReference_doc();
    }

    public Long getTodoId() {
        return this.todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
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

    public String getReferenceDoc() {
        return this.referenceDoc;
    }

    public void setReferenceDoc(String referenceDoc) {
        this.referenceDoc = referenceDoc;
    }
    
}