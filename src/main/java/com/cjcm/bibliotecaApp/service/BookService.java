package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.dto.bookDtos.BookResponseDto;
import com.cjcm.bibliotecaApp.mappers.BookMapper;
import com.cjcm.bibliotecaApp.persistence.entities.BookEntity;
import com.cjcm.bibliotecaApp.persistence.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  public BookService(BookRepository bookRepository, BookMapper bookMapper) {
    this.bookRepository = bookRepository;
    this.bookMapper = bookMapper;
  }

  public List<BookResponseDto> getAllBooks(){

    List<BookEntity> books = bookRepository.findAll();

    return books.stream()
            .map(bookMapper::mapToBookDto)
            .toList();
  }

//  public BookEntity getBookById(Integer id){
//    return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
//  }
//
//  public BookEntity createBook(BookEntity bookEntity){
//    bookEntity = BookEntity.builder()
//            .title(bookEntity.getTitle())
//            .author(bookEntity.getAuthor())
//            .stock(bookEntity.getStock())
//            .isbn(bookEntity.getIsbn())
//            .build();
//
//    return bookRepository.save(bookEntity);
//  }
}
