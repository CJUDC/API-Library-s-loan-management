package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.dto.UserResponseDto;
import com.cjcm.bibliotecaApp.mappers.UserMapper;
import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import com.cjcm.bibliotecaApp.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public List<UserResponseDto> getAllUsers() {

    List<UserEntity> users = userRepository.findAll();

    return users.stream()
            .map(UserMapper::mapToUserResponseDto)
            .toList();
  }

  public UserEntity getUserById(Integer id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }

  public UserEntity createUser(UserEntity userEntity){

    userEntity = UserEntity.builder()
            .email(userEntity.getEmail())
            .name(userEntity.getName())
            .lastName(userEntity.getLastName())
            .password(userEntity.getPassword())
            .build();

    return userRepository.save(userEntity);
  }
}
