package com.cjcm.bibliotecaApp.controller;

import com.cjcm.bibliotecaApp.model_domain.LoanEntity;
import com.cjcm.bibliotecaApp.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

  private final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @GetMapping
  public ResponseEntity<List<LoanEntity>> getAllLoans() {
    List<LoanEntity> loans = loanService.getAllLoans();
    return ResponseEntity.ok(loans);
  }

  @GetMapping("/{loanId}")
  public ResponseEntity<LoanEntity> getLoanById(Integer loanId) {
    return ResponseEntity.ok(loanService.getLoanById(loanId));
  }

}
