package com.cjcm.bibliotecaApp.mappers;

import com.cjcm.bibliotecaApp.dto.loanDtos.LoanRequestDto;
import com.cjcm.bibliotecaApp.dto.loanDtos.LoanResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.LoanBookEntity;
import com.cjcm.bibliotecaApp.persistence.entities.LoanEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

  private final LoanBookMapper loanBookMapper;

  public LoanMapper(LoanBookMapper loanBookMapper) {
    this.loanBookMapper = loanBookMapper;
  }

  public LoanResponseDto mapToLoanDto(LoanEntity loanEntity){
    return LoanResponseDto.builder()
            .loanId(loanEntity.getLoanId())
            .startDate(loanEntity.getStartDate())
            .expireDate(loanEntity.getExpireDate())
            .returnDate(loanEntity.getReturnDate())
            .state(loanEntity.getState())
            .loanBooks(loanBookMapper.mapLoanBooksToDto(loanEntity.getLoanBooks()))
            .build();
  }

  public LoanEntity mapToLoanEntity(LoanRequestDto loanRequestDto){

    LoanEntity loanEntity = new LoanEntity();

    loanEntity.setLoanId(loanRequestDto.loanId());
    loanEntity.setStartDate(loanRequestDto.startDate());
    loanEntity.setExpireDate(loanRequestDto.expireDate());
    loanEntity.setReturnDate(loanRequestDto.returnDate());
    loanEntity.setState(loanRequestDto.state());
    loanEntity.setLoanBooks(loanRequestDto.loanBooks());

    return loanEntity;
  }

}
