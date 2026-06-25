package com.cjcm.bibliotecaApp.dto.bookDtos;

import lombok.Builder;

@Builder
public record BookResponseDto(
        Integer id,
        String title,
        String author,
        Integer stock,
        String isbn
) {
}
