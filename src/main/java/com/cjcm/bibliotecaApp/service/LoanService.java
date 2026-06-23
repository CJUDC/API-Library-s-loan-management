package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.model_domain.LoanEntity;
import com.cjcm.bibliotecaApp.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
  private final LoanRepository loanRepository;

  public LoanService(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }

  public List<LoanEntity> getAllLoans(){
    return loanRepository.findAll();
  }

  public LoanEntity getLoanById(Integer loanId) {
    return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
  }

  public LoanEntity createLoan(LoanEntity loan) {

    loan = LoanEntity.builder()
            .startDate(loan.getStartDate())
            .expireDate(loan.getExpireDate())
            .returnDate(loan.getReturnDate())
            .state(loan.getState())
            .user(loan.getUser())
            .loanBooks(loan.getLoanBooks())
            .build();
    return loanRepository.save(loan);
  }
}
