package com.todolist.demo.repository;
import com.todolist.demo.domain.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Override
    @EntityGraph(attributePaths = {"tasks"})
    @Transactional
    List<Project> findAll();

    @Transactional
    List<Project> findByUserId(Long userId);

}
