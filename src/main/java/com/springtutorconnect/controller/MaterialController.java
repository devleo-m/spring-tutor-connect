package com.springtutorconnect.controller;

import com.springtutorconnect.entity.MaterialEntity;
import com.springtutorconnect.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiais")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping()
    public ResponseEntity<List<MaterialEntity>> getListarMateriais() {
        List<MaterialEntity> material = materialService.listarMaterial();
        return ResponseEntity.status(HttpStatus.OK).body(material);
    }

    @PostMapping()
    public ResponseEntity<MaterialEntity> criarMaterial(@RequestBody MaterialEntity material) {
        MaterialEntity novoMaterial = materialService.criarMaterial(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialEntity> atualizarMaterial(@PathVariable Long id, @RequestBody MaterialEntity material) {
        MaterialEntity materialAtualizado = materialService.atualizarMaterial(id, material);

        if (materialAtualizado != null) {
            return ResponseEntity.ok(materialAtualizado); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMaterial(@PathVariable Long id) {
        materialService.excluirMaterial(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
