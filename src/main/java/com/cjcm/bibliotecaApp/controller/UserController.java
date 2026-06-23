package com.cjcm.bibliotecaApp.controller;

import com.cjcm.bibliotecaApp.model_domain.UserEntity;
import com.cjcm.bibliotecaApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserEntity>> getAllUsers() {
    List<UserEntity> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }


  @GetMapping("/users/{id}")
  public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
    UserEntity user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/users")
  public ResponseEntity<Void> createUser(@RequestBody UserEntity user) {
    userService.createUser(user);
    return ResponseEntity.ok().build();
  }
}
