package com.springtutorconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "agenda")
public class AgendaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private AlunoEntity id_aluno;

    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false)
    private TutorEntity id_tutor;

    @Column(nullable = false)
    private LocalDate data_agenda;

    @Column(nullable = false, length = 10)
    private String status_agenda;

    @Column(nullable = false, length = 150)
    private String tema_agenda;

    private String descricao_breve;

}
