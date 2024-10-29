package com.todolist.demo.service;
import com.todolist.demo.domain.Project;
import com.todolist.demo.domain.Task;
import com.todolist.demo.domain.User;
import com.todolist.demo.repository.ProjectRepository;
import com.todolist.demo.repository.UserRepository;
import com.todolist.demo.service.dto.ProjectDTO;
import com.todolist.demo.service.dto.TaskDTO;
import com.todolist.demo.service.mapper.ProjectMapper;
import com.todolist.demo.web.rest.errors.DuplicateRecordException;
import com.todolist.demo.web.rest.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private UserRepository userRepository;

    // Create
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO); // Convert DTO to entity
//
//        User user = userRepository.findById(projectDTO.getUserId()).orElse(null);
//        project.setUser(user);
        Optional<Project> projects = Optional
                .ofNullable(projectRepository
                        .findById(project.getId()).orElseThrow(() -> new DuplicateRecordException("the data is Duplicate")));

        Project savedProject = projectRepository.save(project); // Save entity to DB
        return projectMapper.toDto(savedProject); // Convert entity back to DTO
    }

    // Read (get all projects)
    public List<ProjectDTO> getAllProjects() {
        List<Project> list = projectRepository.findAll();
        return projectMapper.toDto(list); // Convert list of entities to list of DTOs
    }

    // Read (get project by ID)
    public Optional<ProjectDTO> getProjectById(Long id) {
        return Optional.ofNullable(projectRepository.findById(id)
                .map(projectMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("the data is "+ id +" not found"))); // Convert entity to DTO if present
    }


    // Get Project By User ID
    public List<ProjectDTO> findByUserId(Long userId){
        List<Project> projects = projectRepository.findByUserId(userId);
        return projectMapper.toDto(projects);

    }

    // Update (existing project)
    public Optional<ProjectDTO> updateProject(Long id, ProjectDTO projectDTO) {
        return projectRepository.findById(id).map(existingProject -> {// Update entity fields with DTO values
            Project updatedProject = projectRepository.save(existingProject); // Save the updated entity
            return projectMapper.toDto(updatedProject); // Convert entity back to DTO
        });
    }

    // Delete (project by ID)
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
