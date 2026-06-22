package com.cjcm.bibliotecaApp.model_domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userID;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 200)
  private String lastName;

  @Column(nullable = false, length = 200)
  private String password;
}
