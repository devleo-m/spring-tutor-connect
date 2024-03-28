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
    private Long id_agenda;
    private String descricao_material;
    private String caminho_arquivo;
}
