package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.TutorEntity;
import com.springtutorconnect.repository.TutorRepository;
import com.springtutorconnect.service.TutorService;

import java.util.List;

public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public TutorEntity criarTutor(TutorEntity tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public List<TutorEntity> listarTutor() {
        return tutorRepository.findAll();
    }

    @Override
    public TutorEntity atualizarTutor(Long id, TutorEntity tutor) {
        if (tutorRepository.existsById(id)){
            tutor.setId_tutor(id);
            return tutorRepository.save(tutor);
        }
        return null;
    }

    @Override
    public void excluirTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
