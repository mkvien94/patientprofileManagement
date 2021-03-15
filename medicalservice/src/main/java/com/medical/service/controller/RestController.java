package com.medical.service.controller;

import com.medical.service.entity.implement.medicalEntity;
import com.medical.service.service.implement.medicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping (path = "/medical")
public class RestController {

    @Autowired
    private medicalService service;

    @GetMapping (path = "/all")
    public ResponseEntity<List<medicalEntity>> geAll() {
        try {
            return new ResponseEntity<>(service.getAllMedical(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<medicalEntity> getMedicalById (@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path = "/name/{name}")
    public ResponseEntity<List<medicalEntity>> getMedicalByName( @PathVariable String name) {
        try {
            return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (path = "/save")
    public ResponseEntity<medicalEntity> createNewMedical (@RequestBody medicalEntity model) {
        try {
            return new ResponseEntity<>(service.insert(model), HttpStatus.OK);
        }catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping (path = "/update")
    public  ResponseEntity<medicalEntity> update (@RequestBody medicalEntity model) {
        try {
            return new ResponseEntity<>(service.update(model), HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
