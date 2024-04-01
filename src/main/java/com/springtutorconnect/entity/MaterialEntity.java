package com.springtutorconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "materiais")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    private AgendaEntity agenda;

    private String descricao;

    @Column(nullable = false)
    private String caminhoArquivo;

}
