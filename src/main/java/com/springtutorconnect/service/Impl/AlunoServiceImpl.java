package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.AlunoEntity;
import com.springtutorconnect.repository.AgendaRepository;
import com.springtutorconnect.repository.AlunoRepository;
import com.springtutorconnect.service.AlunoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AlunoEntity criarAluno(AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<AlunoEntity> listarAluno() {
        return alunoRepository.findAll();
    }

    @Override
    public AlunoEntity atualizarAluno(Long id, AlunoEntity aluno) {
        if (alunoRepository.existsById(id)){
            aluno.setId_aluno(id);
            return alunoRepository.save(aluno);
        }
        return null;
    }

    @Override
    public void excluirAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
