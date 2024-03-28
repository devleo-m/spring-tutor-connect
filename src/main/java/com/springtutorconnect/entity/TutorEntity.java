package com.springtutorconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tutor")
public class TutorEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tutor;
    private String nome_tutor;
    private String especialidade_tutor;
}
