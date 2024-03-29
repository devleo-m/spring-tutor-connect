package com.springtutorconnect.controller;

import com.springtutorconnect.entity.TutorEntity;
import com.springtutorconnect.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tutores")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping()
    public ResponseEntity<List<TutorEntity>> listarTutores() {
        List<TutorEntity> tutor = tutorService.listarTutor();
        return ResponseEntity.status(HttpStatus.OK).body(tutor);
    }

    @PostMapping()
    public ResponseEntity<TutorEntity> criarTutor(@RequestBody TutorEntity tutor) {
        TutorEntity novoTutor = tutorService.criarTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorEntity> atualizarTutor(@PathVariable Long id, @RequestBody TutorEntity tutor) {
        TutorEntity tutorAtualizado = tutorService.atualizarTutor(id, tutor);

        if (tutorAtualizado != null) {
            return ResponseEntity.ok(tutorAtualizado); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTutor(@PathVariable Long id) {
        tutorService.excluirTutor(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
