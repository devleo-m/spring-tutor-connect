package com.springtutorconnect.controller;

import com.springtutorconnect.entity.AlunoEntity;
import com.springtutorconnect.service.AlunoService;
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
    public List<AlunoEntity> listarAlunos(){
        return alunoService.listarAluno();
    }

    @PostMapping("/{id}")
    public AlunoEntity criarAluno(@RequestBody AlunoEntity aluno){
        return alunoService.criarAluno(aluno);
    }
}
