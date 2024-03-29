package com.springtutorconnect.controller;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping()
    public ResponseEntity<List<AgendaEntity>> listarAgendas() {
        List<AgendaEntity> agenda = agendaService.listarAgendas();
        return ResponseEntity.status(HttpStatus.OK).body(agenda);
    }

    @PostMapping()
    public ResponseEntity<AgendaEntity> criarAgenda(@RequestBody AgendaEntity agenda) {
        AgendaEntity novaAgenda = agendaService.criarAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAgenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaEntity> atualizarAgenda(@PathVariable Long id, @RequestBody AgendaEntity agenda) {
        AgendaEntity atualarAgenda = agendaService.atualizarAgenda(id, agenda);
        //return ResponseEntity.status(HttpStatus.OK).body(aluno);
        if (atualarAgenda != null) {
            return ResponseEntity.ok(atualarAgenda); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Long id) {
        agendaService.excluirAgenda(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
