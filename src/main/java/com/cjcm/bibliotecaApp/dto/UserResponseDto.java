package com.cjcm.bibliotecaApp.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        Integer id,
        String email,
        String name,
        String lastName
) {
}
