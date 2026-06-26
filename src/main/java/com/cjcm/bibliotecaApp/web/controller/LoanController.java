package com.cjcm.bibliotecaApp.web.controller;

import com.cjcm.bibliotecaApp.dto.loanDtos.LoanResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.LoanEntity;
import com.cjcm.bibliotecaApp.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

  private final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @GetMapping
  public ResponseEntity<List<LoanResponseDto>> getAllLoans() {
    List<LoanResponseDto> loans = loanService.getAllLoans();
    return ResponseEntity.ok(loans);
  }

//  @GetMapping("/{loanId}")
//  public ResponseEntity<LoanEntity> getLoanById(Integer loanId) {
//    return ResponseEntity.ok(loanService.getLoanById(loanId));
//  }
//
//  @PostMapping("/create")
//  public ResponseEntity<Void> createLoan(@RequestBody LoanEntity loan) {
//    loanService.createLoan(loan);
//    return ResponseEntity.ok().build();
//  }

}
