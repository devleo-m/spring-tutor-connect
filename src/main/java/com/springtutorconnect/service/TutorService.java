package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.TutorEntity;

import java.util.List;

public interface TutorService {
    List<TutorEntity> buscarTodos();

    TutorEntity buscarPorId(Long id);

    TutorEntity criar(TutorEntity entity);

    TutorEntity alterar(Long id, TutorEntity entity);

    void excluir(Long id);
}
