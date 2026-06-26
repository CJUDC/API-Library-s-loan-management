package com.cjcm.bibliotecaApp.dto.loanBooksDtos;

import lombok.Builder;

@Builder
public record LoanBookResponseDto(
        Integer loanBookId,
        Integer bookId,
        String title,
        String author,
        String isbn
) {
}
