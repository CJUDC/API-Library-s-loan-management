package com.cjcm.bibliotecaApp.model_domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "loans")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer loanId;

  @Column
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime expireDate;

  @Column
  private LocalDateTime returnDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "loan_state", nullable = false)
  private LoanState state;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @OneToMany(mappedBy = "loan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<LoanBookEntity> loanBooks;
}
