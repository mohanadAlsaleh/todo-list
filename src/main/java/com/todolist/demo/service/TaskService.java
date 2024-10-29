package com.todolist.demo.service;

import com.todolist.demo.domain.Task;
import com.todolist.demo.repository.TaskRepository;
import com.todolist.demo.service.dto.TaskDTO;
import com.todolist.demo.service.mapper.TaskMapper; // Import your TaskMapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    // Create Task
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    // Get All Tasks
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toDto(tasks);
    }

    // Get Task By ID
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return taskMapper.toDto(task);
    }

    // Update Task
    public Optional<TaskDTO> updateTask(Long id, TaskDTO taskDTO) {
        return taskRepository.findById(id).map(existingTask -> {
            Task updatedTask = taskRepository.save(existingTask);
            return taskMapper.toDto(updatedTask);
        });
    }


    // Get Task By project ID
    public List<TaskDTO> findByProjectId(Long id) {
         List<Task> task = taskRepository.findByProjectId(id);
        return taskMapper.toDto(task);

    }

    // Get Task By User ID
    public List<TaskDTO> findByUserId(Long userId){
        List<Task> task = taskRepository.findByUserId(userId);
        return taskMapper.toDto(task);

    }
    // Delete Task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
