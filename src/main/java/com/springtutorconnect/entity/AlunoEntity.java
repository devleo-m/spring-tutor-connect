package com.springtutorconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alunos")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

}
