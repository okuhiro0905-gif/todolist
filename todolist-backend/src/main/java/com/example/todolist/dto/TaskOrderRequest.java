package com.example.todolist.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class TaskOrderRequest {

    @NotEmpty(message = "taskIds is required")
    private List<Long> taskIds;

    public TaskOrderRequest() {
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }
}
