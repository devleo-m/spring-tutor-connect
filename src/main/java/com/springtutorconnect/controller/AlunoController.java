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
    public ResponseEntity<List<AlunoEntity>> getListarAlunos() {
        List<AlunoEntity> alunos = alunoService.listarAluno();
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    @PostMapping()
    public ResponseEntity<AlunoEntity> criarAluno(@RequestBody AlunoEntity aluno) {
        AlunoEntity novoAluno = alunoService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> atualizarAluno(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        AlunoEntity alunoAtualizado = alunoService.atualizarAluno(id, aluno);

        if (alunoAtualizado != null) {
            return ResponseEntity.ok(alunoAtualizado); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.excluirAluno(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
