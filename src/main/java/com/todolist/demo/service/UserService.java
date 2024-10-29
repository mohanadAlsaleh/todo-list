package com.todolist.demo.service;

import com.todolist.demo.domain.User;
import com.todolist.demo.repository.UserRepository;
import com.todolist.demo.service.dto.UserDTO;
import com.todolist.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    // Convert all users to DTOs
    public List<UserDTO> getAllUsers() {
        return userMapper.toDto(userRepository.findAll()); // Convert to UserDTO list
    }

    public Optional<UserDTO> findUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto); // Convert to UserDTO
    }

    public Optional<UserDTO> findByUserName(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toDto); // Convert to UserDTO
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO); // Convert UserDTO to User entity
        User savedUser = userRepository.save(user); // Save the User entity
        return userMapper.toDto(savedUser); // Return UserDTO
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id); // Deleting by ID remains unchanged
    }
}
