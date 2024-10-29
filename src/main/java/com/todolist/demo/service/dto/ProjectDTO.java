package com.todolist.demo.service.dto;
import com.todolist.demo.domain.Task;

import java.io.Serializable;
import java.util.List;


public class ProjectDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private List<TaskDTO> tasks; // or you can create a TaskDTO instead of using IDs if needed
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
