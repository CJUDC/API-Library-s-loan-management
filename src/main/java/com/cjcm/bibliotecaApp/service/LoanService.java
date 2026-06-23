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
}
