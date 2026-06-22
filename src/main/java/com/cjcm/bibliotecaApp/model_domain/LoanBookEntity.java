package com.cjcm.bibliotecaApp.model_domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_books")
@Getter @Setter
@NoArgsConstructor
public class LoanBookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer loanBookId;


}
