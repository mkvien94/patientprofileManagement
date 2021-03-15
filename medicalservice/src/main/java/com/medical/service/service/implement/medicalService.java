package com.medical.service.service.implement;

import com.medical.service.entity.implement.medicalEntity;
import com.medical.service.repository.medicalRepository;
import com.medical.service.service.AbstractService.AbstractBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class medicalService implements AbstractBasicService<medicalEntity> {

    @Autowired
    private medicalRepository repository;

    @Override
    public List<medicalEntity> getAllMedical() {
        List<medicalEntity> list = repository.findAll();
        return list.isEmpty() ? null : list;
    }

    @Override
    public List<medicalEntity> findByName(String name) {
        List<medicalEntity> list = repository.findByMedicalName(name);
        return list.isEmpty() ? null :  list;
    }

    @Override
    public medicalEntity findById(Long id) {
       try {
           Optional<medicalEntity> optional = repository.findById(id);
           return optional.isPresent() ? optional.get() : null;
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public medicalEntity insert(medicalEntity model) {
        try {
            return repository.save(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public medicalEntity update(medicalEntity model) {
        try {
            //find object where need update
            Optional<medicalEntity> optional = repository.findById(model.getId());
            if (optional.isPresent()) {
                //crush the variables of object that found
                medicalEntity medical = optional.get();
                medical.setMedicalName(model.getMedicalName());
                medical.setAmount(model.getAmount());
                medical.setPrice(model.getPrice());
                medical.setType(model.getType());
                medical.setBeginImport(model.getBeginImport());
                return repository.save(medical);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public medicalEntity remove(medicalEntity model) {
        return null;
    }
}
