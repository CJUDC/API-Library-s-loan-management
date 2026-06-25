package com.cjcm.bibliotecaApp.persistence.repository;

import com.cjcm.bibliotecaApp.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
