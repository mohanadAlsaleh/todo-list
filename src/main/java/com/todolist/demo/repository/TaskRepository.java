package com.todolist.demo.repository;

import com.todolist.demo.domain.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Transactional(readOnly = true)
    List<Task> findByProjectId(Long projectId);
    List<Task> findByUserId(Long userId);
}
