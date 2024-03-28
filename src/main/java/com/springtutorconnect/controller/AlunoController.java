package com.springtutorconnect.controller;

import com.springtutorconnect.entity.AlunoEntity;
import com.springtutorconnect.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping()
    public ResponseEntity<List<AlunoEntity>> listarAlunos() {
        List<AlunoEntity> alunos = alunoService.listarAluno();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AlunoEntity> criarAluno(@RequestBody AlunoEntity aluno) {
        try {
            AlunoEntity novoAluno = alunoService.criarAluno(aluno);
            return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> atualizarAluno(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        try {
            AlunoEntity alunoAtualizado = alunoService.atualizarAluno(id, aluno);
            if (alunoAtualizado != null) {
                return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        try {
            alunoService.excluirAluno(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
