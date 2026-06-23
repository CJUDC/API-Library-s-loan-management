package com.cjcm.bibliotecaApp.controller;

import com.cjcm.bibliotecaApp.model_domain.BookEntity;
import com.cjcm.bibliotecaApp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<BookEntity>> getAllBooks() {
    List<BookEntity> books = bookService.getAllBooks();
    return ResponseEntity.ok(books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookEntity> getBookById(@PathVariable Integer id) {
    BookEntity book = bookService.getBookById(id);
    return ResponseEntity.ok(book);
  }

  @PostMapping("/add")
  public ResponseEntity<Void> createBook(@RequestBody BookEntity book) {
    bookService.createBook(book);
    return ResponseEntity.ok().build();
  }
}
