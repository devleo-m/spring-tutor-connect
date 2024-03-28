package com.springtutorconnect.service;

import com.springtutorconnect.entity.MaterialEntity;

import java.util.List;

public interface MaterialService {
    MaterialEntity criarMaterial(MaterialEntity material);

    List<MaterialEntity> listarMaterial();

    MaterialEntity atualizarMaterial(Long id, MaterialEntity material);

    void excluirMaterial(Long id);
}
