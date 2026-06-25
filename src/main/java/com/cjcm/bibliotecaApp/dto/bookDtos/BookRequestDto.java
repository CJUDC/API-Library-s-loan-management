package com.cjcm.bibliotecaApp.dto.bookDtos;

import lombok.Builder;

@Builder
public record BookRequestDto(
        String title,
        String author,
        Integer stock,
        String isbn
) {
}
