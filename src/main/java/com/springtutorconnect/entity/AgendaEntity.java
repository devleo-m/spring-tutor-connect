package com.springtutorconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "agenda")
public class AgendaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda;
    private Long id_aluno;
    private Long id_tutor;
    private Date data_agenda;
    private String status_agenda;
    private String tema_agenda;
    private String descricao_breve;

}
