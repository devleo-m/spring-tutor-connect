package com.springtutorconnect.service.Impl;

import com.springtutorconnect.entity.MaterialEntity;
import com.springtutorconnect.exception.Error.NotFoundException;
import com.springtutorconnect.repository.MaterialRepository;
import com.springtutorconnect.service.MaterialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public MaterialEntity criarMaterial(MaterialEntity material) {
        return materialRepository.save(material);
    }

    @Override
    public MaterialEntity listarMaterialPorId(Long id) {
        return materialRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Aluno não encontrado com id: "+ id));
    }

    @Override
    public List<MaterialEntity> listarMaterial() {
        return materialRepository.findAll();
    }

    @Override
    public MaterialEntity atualizarMaterial(Long id, MaterialEntity material) {
        if (materialRepository.existsById(id)){
            material.setId_material(id);
            return materialRepository.save(material);
        }
        return null;
    }

    @Override
    public void excluirMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}
