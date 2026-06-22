package com.cjcm.bibliotecaApp.repository;

import com.cjcm.bibliotecaApp.model_domain.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
}
