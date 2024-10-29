package com.todolist.demo.service.mapper;

import com.todolist.demo.domain.User;
import com.todolist.demo.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class, UserMapper.class})
public interface UserMapper  extends EntityMapper<UserDTO, User> {
}
