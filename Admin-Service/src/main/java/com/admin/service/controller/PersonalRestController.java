package com.admin.service.controller;

import com.admin.service.entity.ImplementEntity.PersonEntity;
import com.admin.service.model.modelProxy.medical;
import com.admin.service.model.modelProxy.patient;
import com.admin.service.proxy.PatientClient.PatientClient;
import com.admin.service.proxy.PatientClient.medicalClient;
import com.admin.service.service.ImplementServices.PersonalService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/admin")
public class PersonalRestController {

    @Autowired
    private PersonalService service;

    @Autowired
    private PatientClient client;

    @Autowired
    private medicalClient client1;

    @GetMapping (path = "/all")
    public ResponseEntity<List<PersonEntity>> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<PersonEntity> findPersonalById(@PathVariable Long id ) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (path = "/save")
    public ResponseEntity<PersonEntity> createNewPerson (@RequestBody PersonEntity model) {
        try {
            return new ResponseEntity<>(service.insert(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping (path = "/update")
    public ResponseEntity<PersonEntity> updatePerson (@RequestBody PersonEntity model) {
        try {
            return new ResponseEntity<>(service.update(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (path = "/patient/all")
    public ResponseEntity<List> getAllPatientClient() {
        try {
            List list = client.getAllPatient();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (path = "/patient/{id}")
    public ResponseEntity<Object> getPatientById (@PathVariable Long id) {
        try {
            Object object = client.getPatientById(id);

            return new ResponseEntity<>(object, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path = "/medical/all")
    public ResponseEntity<List> getAllMedical() {
        try {
            return new ResponseEntity<>(client1.getAllMedical(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path = "/medical/{id}")
    public ResponseEntity<Object> getMedicalById (@PathVariable Long id) {
        try {

            return new ResponseEntity<>(client1.getMedicalById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (path = "/patient/save")
    public ResponseEntity<Object> createNewPatient (@RequestBody patient model) {
        try {
            return new ResponseEntity<>(client.createNewPatient(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping (path = "/patient/update")
    public ResponseEntity<Object> updatePatient (@RequestBody patient model) {
        try {
            return new ResponseEntity<>(client.updatePatient(model),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping (path = "/medical/save")
    public ResponseEntity<Object> createNewMedical (@RequestBody medical model) {
        try {
            return new ResponseEntity<>(client1.createNewMedical(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping (path = "/medical/update")
    public ResponseEntity<Object> updateMedical (@RequestBody medical model) {
        try {
            return new ResponseEntity<>(client1.updateMedical(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
