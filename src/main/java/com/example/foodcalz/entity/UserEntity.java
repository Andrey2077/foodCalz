package com.example.foodcalz.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Column
    private String name;

    @Column
    private LocalDateTime createdAt;

}
