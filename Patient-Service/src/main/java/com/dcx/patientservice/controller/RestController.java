package com.dcx.patientservice.controller;

import com.dcx.patientservice.entity.Implement.patientEntity;
import com.dcx.patientservice.service.Implement.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping (path = "/patient")
public class RestController {

    @Autowired
    private PatientService service;

    @GetMapping (path = "/all")
    public ResponseEntity<List<patientEntity>> getAll() {
        try {
            return new ResponseEntity<>(service.findPatientAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<patientEntity> getPatientById (@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.findPatientById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/recordId/{name}")
    public ResponseEntity<List<patientEntity>> getAllRecordId (@PathVariable String name) {
        try {
            return new ResponseEntity<>(service.findByRecordId(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<List<patientEntity>> findByFullName(@PathVariable String name) {
        return new ResponseEntity<>(service.findByFullName(name), HttpStatus.OK);
    }

    @PostMapping (path = "/save")
    public ResponseEntity<patientEntity> createNewPatient (@RequestBody patientEntity model) {
        try {
            return new ResponseEntity<>(service.save(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping (path = "/update")
    public ResponseEntity<patientEntity> updatePatient (@RequestBody patientEntity model) {
        try {
            return new ResponseEntity<>(service.update(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<String> delelePatient(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/medical/{name}")
    public ResponseEntity<List<patientEntity>> findByMedicalName(@PathVariable String name) {
        return new ResponseEntity<>(service.findByMedicalName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/disease/{name}")
    public ResponseEntity<List<patientEntity>> findByDiseaseName(@PathVariable String name) {
        return new ResponseEntity<>(service.findByDiseaseName(name), HttpStatus.OK);
    }
}
