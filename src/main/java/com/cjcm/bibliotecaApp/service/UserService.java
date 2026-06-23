package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.model_domain.UserEntity;
import com.cjcm.bibliotecaApp.repository.UserRepository;
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


}
