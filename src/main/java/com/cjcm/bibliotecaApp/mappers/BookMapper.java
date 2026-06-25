package com.cjcm.bibliotecaApp.mappers;

import com.cjcm.bibliotecaApp.dto.bookDtos.BookResponseDto;
import com.cjcm.bibliotecaApp.persistence.entities.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

  public BookResponseDto mapToBookDto(BookEntity bookEntity){
    return BookResponseDto.builder()
            .id(bookEntity.getBookId())
            .title(bookEntity.getTitle())
            .author(bookEntity.getAuthor())
            .stock(bookEntity.getStock())
            .isbn(bookEntity.getIsbn())
            .build();
  }
}
