package com.cjcm.bibliotecaApp.mappers;

import com.cjcm.bibliotecaApp.dto.loanBooksDtos.LoanBookResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.LoanBookEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanBookMapper {

  public List<LoanBookResponseDto> mapLoanBooksToDto(List<LoanBookEntity> loanBooks) {
    if (loanBooks == null) {
      return List.of();
    }
    return loanBooks.stream()
            .map(lb -> LoanBookResponseDto.builder()
                    .loanBookId(lb.getLoanBookId())
                    .bookId(lb.getBook().getBookId())
                    .title(lb.getBook().getTitle())
                    .author(lb.getBook().getAuthor())
                    .isbn(lb.getBook().getIsbn())
                    .build())
            .toList();
  }


}
