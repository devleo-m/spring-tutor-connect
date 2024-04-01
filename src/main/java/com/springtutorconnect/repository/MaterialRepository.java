package com.springtutorconnect.repository;

import com.springtutorconnect.entity.AgendaEntity;
import com.springtutorconnect.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    List<MaterialEntity> findByAgenda(AgendaEntity agenda);

}
