package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.AlunoEntity;
import com.springtutorconnect.exception.NotFoundException;
import com.springtutorconnect.repository.AlunoRepository;
import com.springtutorconnect.service.AlunoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlunoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AlunoEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado com id: " + id));
    }

    @Override
    public AlunoEntity criar(AlunoEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public AlunoEntity alterar(Long id, AlunoEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AlunoEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}
