package com.cjcm.bibliotecaApp.web.controller;

import com.cjcm.bibliotecaApp.dto.UserRequestDto;
import com.cjcm.bibliotecaApp.dto.UserResponseDto;
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
  public ResponseEntity<List<UserResponseDto>> getAllUsers() {
    List<UserResponseDto> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }


  @GetMapping("/users/{id}")
  public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {
    UserResponseDto user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/add")
  public ResponseEntity<Void> createUser(@RequestBody UserRequestDto userRequest) {

    userService.createUser(userRequest);

    return ResponseEntity.ok().build();
  }
}
