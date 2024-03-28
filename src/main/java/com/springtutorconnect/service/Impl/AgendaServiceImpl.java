package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.repository.AgendaRepository;
import com.springtutorconnect.service.AgendaService;

import java.util.List;

public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public AgendaEntity criarAgenda(AgendaEntity agenda) {
        return agendaRepository.save(agenda);
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
        agendaRepository.deleteById(id);
    }
}
