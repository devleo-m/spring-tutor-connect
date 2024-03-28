package com.springtutorconnect.service;

import com.springtutorconnect.entity.TutorEntity;

import java.util.List;

public interface TutorService {
    TutorEntity criarTutor(TutorEntity tutor);

    List<TutorEntity> listarTutor();

    TutorEntity atualizarTutor(Long id, TutorEntity tutor);

    void excluirTutor(Long id);
}
