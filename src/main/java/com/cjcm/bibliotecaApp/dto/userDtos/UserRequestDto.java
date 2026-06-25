package com.cjcm.bibliotecaApp.dto.userDtos;

import lombok.Builder;

@Builder
public record UserRequestDto(
        String email,
        String name,
        String lastName,
        String password)
{

}
