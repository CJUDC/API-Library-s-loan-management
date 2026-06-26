package com.cjcm.bibliotecaApp.mappers;

import com.cjcm.bibliotecaApp.dto.loanDtos.LoanResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.LoanEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

  public LoanResponseDto mapToLoanDto(LoanEntity  loanEntity){
    return LoanResponseDto.builder()
            .loanId(loanEntity.getLoanId())
            .startDate(loanEntity.getStartDate())
            .expireDate(loanEntity.getExpireDate())
            .returnDate(loanEntity.getReturnDate())
            .state(loanEntity.getState())
            .loanBooks(loanEntity.getLoanBooks())
            .build();
  }



}
