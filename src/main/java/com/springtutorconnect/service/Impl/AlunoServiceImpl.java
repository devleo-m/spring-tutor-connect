package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.AlunoEntity;
import com.springtutorconnect.exception.Error.NotFoundException;
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
        aluno.setId_aluno(null);
        return alunoRepository.save(aluno);
    }

    @Override
    public AlunoEntity listarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Aluno não encontrado com id: "+ id));
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
        AlunoEntity aluno = listarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }
}
