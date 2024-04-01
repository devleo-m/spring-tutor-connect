package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.MaterialEntity;

import java.util.List;

public interface MaterialService {
    MaterialEntity criarMaterial(MaterialEntity material);

    MaterialEntity listarMaterialPorId(Long id);

    List<MaterialEntity> listarMaterial();

    MaterialEntity atualizarMaterial(Long id, MaterialEntity material);

    void excluirMaterial(Long id);
}
