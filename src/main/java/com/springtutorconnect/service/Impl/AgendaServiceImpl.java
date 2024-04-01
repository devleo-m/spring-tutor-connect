package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.exception.Error.NotFoundException;
import com.springtutorconnect.repository.AgendaRepository;
import com.springtutorconnect.service.AgendaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public AgendaEntity criarAgenda(AgendaEntity agenda) {
        agenda.setId_agenda(null);
        return agendaRepository.save(agenda);
    }

    @Override
    public AgendaEntity listarAgendaPorId(Long id) {
        return agendaRepository.findById(id)
                                .orElseThrow( () -> new NotFoundException("Lista de agenda não encontrado com id: "+ id));

    }

    @Override
    public List<AgendaEntity> listarAgendas() {
        return agendaRepository.findAll();
    }

    @Override
    public AgendaEntity atualizarAgenda(Long id, AgendaEntity agenda) {
        if (agendaRepository.existsById(id)){
            agenda.setId_agenda(id);
            return agendaRepository.save(agenda);
        }
        return null;
    }

    @Override
    public void excluirAgenda(Long id) {
        AgendaEntity agenda = listarAgendaPorId(id);
        agendaRepository.delete(agenda);
    }
}
