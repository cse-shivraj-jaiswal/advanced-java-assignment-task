package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO dto);

    void deleteUser(Long id);
}