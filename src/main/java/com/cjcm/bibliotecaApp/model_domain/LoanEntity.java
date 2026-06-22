package com.cjcm.bibliotecaApp.model_domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Getter @Setter
@NoArgsConstructor
public class LoanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer loanId;

  @Column(nullable = false)
  private LocalDateTime expireDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "loan_state", nullable = false)
  private LoanState state;


}
