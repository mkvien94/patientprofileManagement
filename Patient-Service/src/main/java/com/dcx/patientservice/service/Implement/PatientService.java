package com.dcx.patientservice.service.Implement;

import com.dcx.patientservice.entity.Implement.patientEntity;
import com.dcx.patientservice.repository.patientRepository;
import com.dcx.patientservice.service.AbstractBasictService.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements AbstractService<patientEntity> {

    @Autowired
    private patientRepository repository;

    @Override
    public List<patientEntity> findPatientAll() {
        try {
            List<patientEntity> list = repository.findAll();
            return list.isEmpty() ? null : list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public patientEntity findPatientById(Long Id) {
        try {
            Optional<patientEntity> patient = repository.findById(Id);
            return patient.isPresent() ? patient.get() : null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<patientEntity> findByRecordId(String name) {
       try {
           List<patientEntity> list = repository.findByRecordId(name);
           return list.isEmpty() ? null : list;
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public patientEntity save(patientEntity model) {
       try {
           return repository.save(model);
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public patientEntity update(patientEntity model) {
       try {
           return repository.save(model);
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public patientEntity remove(Long Id) {
        return null;
    }
}
