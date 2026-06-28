package com.cjcm.bibliotecaApp.service;

import com.cjcm.bibliotecaApp.dto.loanDtos.LoanRequestDto;
import com.cjcm.bibliotecaApp.dto.loanDtos.LoanResponseDto;
import com.cjcm.bibliotecaApp.mappers.LoanBookMapper;
import com.cjcm.bibliotecaApp.mappers.LoanMapper;
import com.cjcm.bibliotecaApp.persistence.entities.BookEntity;
import com.cjcm.bibliotecaApp.persistence.entities.LoanBookEntity;
import com.cjcm.bibliotecaApp.persistence.entities.LoanEntity;
import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import com.cjcm.bibliotecaApp.persistence.repository.BookRepository;
import com.cjcm.bibliotecaApp.persistence.repository.LoanRepository;
import com.cjcm.bibliotecaApp.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanService {
  private final LoanRepository loanRepository;
  private final LoanMapper loanMapper;
  private final LoanBookMapper loanBookMapper;
  private final BookRepository bookRepository;
  private final UserRepository userRepository;

  public LoanService(LoanRepository loanRepository, LoanMapper loanMapper, LoanBookMapper loanBookMapper, BookRepository bookRepository, UserRepository userRepository) {
    this.loanRepository = loanRepository;
    this.loanMapper = loanMapper;
    this.loanBookMapper = loanBookMapper;
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
  }

  public List<LoanResponseDto> getAllLoans(){

    List<LoanEntity> loanEntities = loanRepository.findAll();

    return loanEntities.stream()
            .map(loanMapper::mapToLoanDto)
            .toList();
  }

  public LoanResponseDto getLoanById(Integer loanId) {

    LoanEntity loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));

    return loanMapper.mapToLoanDto(loan);
  }

  @Transactional
  public LoanResponseDto createLoan(LoanRequestDto loanRequestDto) {

    UserEntity user = userRepository.findById(loanRequestDto.userId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + loanRequestDto.userId()));

    List<BookEntity> books = loanRequestDto.loanBooks().stream()
            .map(b -> bookRepository.findById(b.bookId())
                    .orElseThrow(() -> new RuntimeException("Book not found with id: " + b.bookId())))
            .toList();

    LoanEntity loanEntity = loanMapper.mapToLoanEntity(loanRequestDto);
    loanEntity.setUser(user);

    List<LoanBookEntity> loanBooks = loanBookMapper.mapToLoanBooksEntity(books);
    loanBooks.forEach(lb -> lb.setLoan(loanEntity));
    loanEntity.setLoanBooks(loanBooks);

    loanRepository.save(loanEntity);

    return loanMapper.mapToLoanDto(loanEntity);
  }
}
