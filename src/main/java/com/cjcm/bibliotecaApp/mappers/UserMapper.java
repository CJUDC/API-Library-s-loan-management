package com.cjcm.bibliotecaApp.mappers;

import com.cjcm.bibliotecaApp.dto.userDtos.UserRequestDto;
import com.cjcm.bibliotecaApp.dto.userDtos.UserResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserResponseDto mapToUserResponseDto(UserEntity userEntity) {
    // Implementation for mapping UserEntity to UserResponseDto
    return UserResponseDto.builder()
            .id(userEntity.getUserId())
            .email(userEntity.getEmail())
            .name(userEntity.getName())
            .lastName(userEntity.getLastName())
            .build();
  }

  public UserEntity mapToUserEntity(UserRequestDto userRequestDto){

    UserEntity userEntity = new UserEntity();

    userEntity.setEmail(userRequestDto.email());
    userEntity.setName(userRequestDto.name());
    userEntity.setLastName(userRequestDto.lastName());
    userEntity.setPassword(userRequestDto.password());

    return userEntity;
  }
}
