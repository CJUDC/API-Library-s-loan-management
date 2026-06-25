package com.cjcm.bibliotecaApp.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer bookId;

  @Column(nullable = false, length = 255)
  private String title;

  @Column(nullable = false, length = 100)
  private String author;

  @Column(nullable = false)
  private Integer stock;

  @Column(nullable = false, unique = true, length = 20)
  private String isbn;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
  @JsonIgnore
  private List<LoanBookEntity> loanBooks;
}
