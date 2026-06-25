package com.cjcm.bibliotecaApp.mappers;

import com.cjcm.bibliotecaApp.dto.UserRequestDto;
import com.cjcm.bibliotecaApp.dto.UserResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

//  public UserEntity mapToUserEntity(UserRequestDto userRequestDto){
//
//  } TODO

  public UserResponseDto mapToUserResponseDto(UserEntity userEntity) {
    // Implementation for mapping UserEntity to UserResponseDto
    return UserResponseDto.builder()
            .id(userEntity.getUserId())
            .email(userEntity.getEmail())
            .name(userEntity.getName())
            .lastName(userEntity.getLastName())
            .build();
  }
}
