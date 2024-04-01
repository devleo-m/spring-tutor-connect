package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.TutorEntity;

import java.util.List;

public interface TutorService {
    TutorEntity criarTutor(TutorEntity tutor);

    TutorEntity listarTutorPorId(Long id);

    List<TutorEntity> listarTutor();

    TutorEntity atualizarTutor(Long id, TutorEntity tutor);

    void excluirTutor(Long id);
}
