package com.cjcm.bibliotecaApp.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        String email,
        String name,
        String lastName
) {
}
