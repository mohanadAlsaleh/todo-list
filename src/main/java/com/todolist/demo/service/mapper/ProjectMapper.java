package com.todolist.demo.service.mapper;

import com.todolist.demo.domain.Project;
import com.todolist.demo.service.dto.ProjectDTO;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface ProjectMapper  extends EntityMapper<ProjectDTO, Project> {

    @Override
    @Mapping(target = "tasks", source = "tasks", ignore = true )
    @Mapping(source = "userId" ,target = "user.id" )
    Project toEntity(ProjectDTO dto);

    @Override
    @Mapping(source = "tasks" ,target = "tasks" )
    @Mapping(source = "user.id",target = "userId")
    ProjectDTO toDto(Project entity);
}
