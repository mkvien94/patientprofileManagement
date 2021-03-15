package com.admin.service.controller;

import com.admin.service.entity.ImplementEntity.AccountEntity;
import com.admin.service.service.ImplementServices.AccountService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
public class AccountRestController {

    @Autowired
    private AccountService service;

   @GetMapping (path = "/login")
    public ResponseEntity<AccountEntity> login (@RequestParam(name = "username") String username) {
        try {
           return new ResponseEntity<>(service.findByName(username), org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_OK));
        } catch (Exception e) {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (path = "/delete/{id}")
    public ResponseEntity<AccountEntity> deleteAccount (@PathVariable Long id) {
       try {
           return new ResponseEntity<>(service.remove(id), org.springframework.http.HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
       }
    }
}
