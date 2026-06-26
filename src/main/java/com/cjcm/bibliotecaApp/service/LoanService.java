package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.dto.loanDtos.LoanResponseDto;
import com.cjcm.bibliotecaApp.mappers.LoanMapper;
import com.cjcm.bibliotecaApp.persistence.entities.LoanEntity;
import com.cjcm.bibliotecaApp.persistence.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
  private final LoanRepository loanRepository;
  private final LoanMapper loanMapper;

  public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
    this.loanRepository = loanRepository;
    this.loanMapper = loanMapper;
  }

  public List<LoanResponseDto> getAllLoans(){

    List<LoanEntity> loanEntities = loanRepository.findAll();

    return loanEntities.stream()
            .map(loanMapper::mapToLoanDto)
            .toList();
  }

//  public LoanEntity getLoanById(Integer loanId) {
//    return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
//  }
//
//  public LoanEntity createLoan(LoanEntity loan) {
//
//    loan = LoanEntity.builder()
//            .startDate(loan.getStartDate())
//            .expireDate(loan.getExpireDate())
//            .returnDate(loan.getReturnDate())
//            .state(loan.getState())
//            .user(loan.getUser())
//            .loanBooks(loan.getLoanBooks())
//            .build();
//    return loanRepository.save(loan);
//  }
}
