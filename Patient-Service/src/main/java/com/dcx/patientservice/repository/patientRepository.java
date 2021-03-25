package com.dcx.patientservice.repository;

import com.dcx.patientservice.entity.Implement.patientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface patientRepository extends JpaRepository<patientEntity, Long> {
    List<patientEntity> findByRecordId (String name);

    List<patientEntity> findByDiseasename( String name);

    List<patientEntity> findByMedicalname (String name);

    List<patientEntity> findByFullname( String name);
}
