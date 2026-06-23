package com.cjcm.bibliotecaApp.dto;

import lombok.Builder;

@Builder
public record UserRequestDto(
        String email,
        String name,
        String lastName,
        String password)
{

}
