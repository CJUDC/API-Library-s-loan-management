package com.cjcm.bibliotecaApp.persistence.repository;

import com.cjcm.bibliotecaApp.persistence.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
}
