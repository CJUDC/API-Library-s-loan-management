package com.cjcm.bibliotecaApp.dto.loanBooksDtos;

import lombok.Builder;

@Builder
public record LoanBookRequestDto(
        Integer bookId
) {
}
