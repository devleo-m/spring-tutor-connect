package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.MaterialEntity;

import java.util.List;

public interface MaterialService {
    List<MaterialEntity> buscarTodos();

    MaterialEntity buscarPorId(Long id);

    List<MaterialEntity> buscarPorAgenda(Long agendaId);

    MaterialEntity criar(MaterialEntity entity);

    MaterialEntity alterar(Long id, MaterialEntity entity);

    void excluir(Long id);
}
