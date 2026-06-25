package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.dto.UserRequestDto;
import com.cjcm.bibliotecaApp.dto.UserResponseDto;
import com.cjcm.bibliotecaApp.mappers.UserMapper;
import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import com.cjcm.bibliotecaApp.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
            .map(userMapper::mapToUserResponseDto)
            .toList();
  }

  public UserResponseDto getUserById(Integer id) {

    UserEntity user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));


    return userMapper.mapToUserResponseDto(user);

  }

  public void createUser(UserRequestDto userRequestDto){

    UserEntity userEntity = userMapper.mapToUserEntity(userRequestDto);

    userRepository.save(userEntity);
  }
}
