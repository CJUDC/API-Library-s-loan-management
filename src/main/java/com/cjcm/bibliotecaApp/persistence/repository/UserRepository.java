package com.cjcm.bibliotecaApp.persistence.repository;

import com.cjcm.bibliotecaApp.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
