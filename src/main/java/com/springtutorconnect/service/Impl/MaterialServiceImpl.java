package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.MaterialEntity;
import com.springtutorconnect.exception.NotFoundException;
import com.springtutorconnect.repository.MaterialRepository;
import com.springtutorconnect.service.AgendaService;
import com.springtutorconnect.service.MaterialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MaterialServiceImpl implements MaterialService {

    private final AgendaService agendaService;
    private final MaterialRepository repository;

    public MaterialServiceImpl(AgendaService agendaService, MaterialRepository repository) {
        this.agendaService = agendaService;
        this.repository = repository;
    }

    @Override
    public List<MaterialEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Material não encontrado com id: " + id
                ));
    }

    @Override
    public List<MaterialEntity> buscarPorAgenda(Long agendaId) {
        AgendaEntity agenda = agendaService.buscarPorId(agendaId);
        return repository.findByAgenda(agenda);
    }

    @Override
    public MaterialEntity criar(MaterialEntity entity) {
        entity.setId(null);

        AgendaEntity agenda = agendaService.buscarPorId(entity.getAgenda().getId());
        entity.setAgenda(agenda);

        return repository.save(entity);
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity entity) {
        buscarPorId(id);
        entity.setId(id);

        AgendaEntity agenda = agendaService.buscarPorId(entity.getAgenda().getId());
        entity.setAgenda(agenda);

        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        MaterialEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}
