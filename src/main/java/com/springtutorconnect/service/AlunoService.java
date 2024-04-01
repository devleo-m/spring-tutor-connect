package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.AlunoEntity;

import java.util.List;

public interface AlunoService {
    List<AlunoEntity> buscarTodos();

    AlunoEntity buscarPorId(Long id);

    AlunoEntity criar(AlunoEntity entity);

    AlunoEntity alterar(Long id, AlunoEntity entity);

    void excluir(Long id);
}
