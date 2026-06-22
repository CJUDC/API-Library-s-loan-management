package com.cjcm.bibliotecaApp.repository;

import com.cjcm.bibliotecaApp.model_domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
