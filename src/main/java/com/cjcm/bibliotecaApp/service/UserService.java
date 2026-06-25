package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import com.cjcm.bibliotecaApp.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
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
