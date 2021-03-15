package com.medical.service.repository;

import com.medical.service.entity.implement.medicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface medicalRepository extends JpaRepository<medicalEntity, Long> {
    List<medicalEntity> findByMedicalName (String name);
}
