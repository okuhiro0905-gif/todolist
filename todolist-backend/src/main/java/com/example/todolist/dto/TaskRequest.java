package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

    @NotBlank(message = "title is required")
    @Size(max = 255, message = "title must be within 255 characters")
    private String title;

    @Size(max = 50, message = "category must be within 50 characters")
    private String category;

    private Boolean completed;

    private Integer sortOrder;

    public TaskRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
