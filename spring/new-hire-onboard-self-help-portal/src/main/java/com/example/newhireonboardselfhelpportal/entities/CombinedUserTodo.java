package com.example.newhireonboardselfhelpportal.entities;

/**
 * CombinedUserTodo
 */
public class CombinedUserTodo {
    Long todoId;
    String item;
    String description;
    String category;
    String url;
    String referenceDoc;
    String assignedDate;
    String completionDate;
    Boolean status;

    CombinedUserTodo(UserTodo userTodo) {
        this.todoId = userTodo.getTodo().getId();
        this.item = userTodo.getTodo().getItem();
        this.description = userTodo.getTodo().getDescription();
        this.category = userTodo.getTodo().getCategory();
        this.url = userTodo.getTodo().getUrl();
        this.referenceDoc = userTodo.getTodo().getReference_doc();
        this.assignedDate = userTodo.getAssignedDate();
        this.completionDate = userTodo.getCompletedDate();
        this.status = userTodo.getStatus();
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

    public String getAssignedDate() {
        return this.assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getCompletionDate() {
        return this.completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}