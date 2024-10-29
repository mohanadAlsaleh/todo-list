package com.todolist.demo.web.rest.controller;

import com.todolist.demo.service.ProjectService;
import com.todolist.demo.service.dto.ProjectDTO;
import com.todolist.demo.web.rest.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new ResourceNotFoundException("the Data is " + id +"not found "));
    }

    @GetMapping("/project/{userid}")
    public ResponseEntity<List<ProjectDTO>> getTasksByUserId(@PathVariable Long userid) {
        List<ProjectDTO> projects = projectService.findByUserId(userid);
        return ResponseEntity.ok(projects);
    }

    @PostMapping
    public ProjectDTO createProject(@RequestBody ProjectDTO project) {
        return projectService.createProject(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
//
//    @GetMapping("/all-with-tasks")
//    public ResponseEntity<List<ProjectDTO>> getAllProjectsWithTasks() {
//        List<ProjectDTO> projects = projectService.getAllProjectsWithTasks();
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("/{id}/with-tasks")
//    public ResponseEntity<ProjectDTO> getProjectByIdWithTasks(@PathVariable Long id) {
//        return projectService.getProjectByIdWithTasks(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
}
