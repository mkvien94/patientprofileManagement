package com.admin.service.service.ImplementServices;

import com.admin.service.entity.ImplementEntity.PersonEntity;
import com.admin.service.repository.PersonalRepository;
import com.admin.service.service.AbstractBasicService.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService implements AbstractService<PersonEntity> {

    @Autowired
    private PersonalRepository repository;

    @Override
    public List<PersonEntity> getAll() {
        List<PersonEntity> list = repository.findAll();
        return list.isEmpty() ? null : list;
    }

    @Override
    public PersonEntity findById(Long id) {
        Optional<PersonEntity> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public PersonEntity findByName(String name) {
        return null;
    }

    @Override
    public List<PersonEntity> findAllName(String name) {
        List<PersonEntity> list = repository.findByFullname(name);
        return list.isEmpty() ? null : list;
    }

    @Override
    public PersonEntity insert(PersonEntity model) {
        return repository.save(model);
    }

    @Override
    public PersonEntity update(PersonEntity model) {
        try {
            //find the object where need update
            Optional<PersonEntity> optional = repository.findById(model.getId());
            if (optional.isPresent()) {
                PersonEntity person = optional.get();
                //crush variables of object that found
                person.setFullname(model.getFullname());
                person.setDob(model.getDob());
                person.setAddress(model.getAddress());
                person.setOccupation(model.getOccupation());
                return repository.save(person);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PersonEntity remove(Long id) {
        return null;
    }
}
