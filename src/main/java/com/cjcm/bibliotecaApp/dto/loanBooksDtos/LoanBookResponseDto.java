package com.cjcm.bibliotecaApp.dto.loanBooksDtos;


public record LoanBookResponseDto(
        Integer loanBookId,
        Integer bookId,
        String title,
        String author,
        String isbn
) {
}
