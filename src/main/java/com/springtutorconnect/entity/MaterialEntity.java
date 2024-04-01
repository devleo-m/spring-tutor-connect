package com.springtutorconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "material")
public class MaterialEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_material;

    @ManyToOne
    @JoinColumn(name = "id_agenda", nullable = false)
    private MaterialEntity id_agenda;

    private String descricao_material;

    @Column(nullable = false)
    private String caminho_arquivo;
}
