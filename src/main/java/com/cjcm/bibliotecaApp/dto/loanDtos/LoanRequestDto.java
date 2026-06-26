package com.cjcm.bibliotecaApp.dto.loanDtos;

import com.cjcm.bibliotecaApp.persistence.entities.LoanBookEntity;
import com.cjcm.bibliotecaApp.persistence.entities.LoanState;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record LoanRequestDto(
        Integer loanId,
        LocalDateTime startDate,
        LocalDateTime expireDate,
        LocalDateTime returnDate,
        LoanState state,
        List<LoanBookEntity> loanBooks
) {
}
