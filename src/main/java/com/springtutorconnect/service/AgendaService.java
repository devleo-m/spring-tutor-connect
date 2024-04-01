package com.springtutorconnect.service;

import com.springtutorconnect.entity.AgendaEntity;

import java.util.List;

public interface AgendaService {
    AgendaEntity criarAgenda(AgendaEntity agenda);

    AgendaEntity listarAgendaPorId(Long id);

    List<AgendaEntity> listarAgendas();

    AgendaEntity atualizarAgenda(Long id, AgendaEntity agenda);

    void excluirAgenda(Long id);

}
