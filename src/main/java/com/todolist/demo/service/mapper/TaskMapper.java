package com.todolist.demo.service.mapper;

import com.todolist.demo.domain.Task;
import com.todolist.demo.domain.User;
import com.todolist.demo.service.dto.TaskDTO;
import com.todolist.demo.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {

    @Override
    @Mapping(target = "userid", source = "user.id")
    @Mapping(target = "projectid", source = "project.id")
    TaskDTO toDto(Task task);

    @Override
    @Mapping(source = "projectid", target = "project.id")
    @Mapping(source = "userid", target = "user.id")
    Task toEntity(TaskDTO dto);


}
