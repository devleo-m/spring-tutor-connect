package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.AlunoEntity;

import java.util.List;

public interface AlunoService {
    AlunoEntity criarAluno(AlunoEntity aluno);

    List<AlunoEntity> listarAluno();

    AlunoEntity atualizarAluno(Long id, AlunoEntity aluno);

    void excluirAluno(Long id);
}
