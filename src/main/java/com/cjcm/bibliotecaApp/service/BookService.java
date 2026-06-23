package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.model_domain.BookEntity;
import com.cjcm.bibliotecaApp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<BookEntity> getAllBooks(){
    return bookRepository.findAll();
  }

  public BookEntity getBookById(Integer id){
    return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
  }
}
