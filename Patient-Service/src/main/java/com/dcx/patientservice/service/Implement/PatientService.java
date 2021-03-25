package com.dcx.patientservice.service.Implement;

import com.dcx.patientservice.entity.Implement.patientEntity;
import com.dcx.patientservice.repository.patientRepository;
import com.dcx.patientservice.service.AbstractBasictService.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<patientEntity> findByFullName(String name) {
        return repository.findByFullname(name);
    }

    @Override
    public List<patientEntity> findByDiseaseName(String name) {
        List<patientEntity> list = repository.findByDiseasename(name);
        return list;
    }

    @Override
    public List<patientEntity> findByMedicalName(String name) {
        List<patientEntity> list = repository.findByMedicalname(name);
        return list;
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
        Optional<patientEntity> option = repository.findById(model.getId());
        if (option.isPresent()) {
            patientEntity patient = option.get();
            patient.setRecordId(model.getRecordId());
            patient.setFullname(model.getFullname());
            patient.setDob(model.getDob());
            patient.setAddress(model.getAddress());
            patient.setDiseasename(model.getDiseasename());
            patient.setMedicalname(model.getMedicalname());
            patient.setStrength(model.getStrength());
            patient.setBeginDate(model.getBeginDate());
            patient.setEndDate(model.getEndDate());
            patient.setResult(model.getResult());
            patient.setxRay(model.getxRay());

            return repository.save(patient);
        } else {
            return null;
        }
    }

    @Override
    public void remove(Long Id) {

         repository.deleteById(Id);
    }
}
