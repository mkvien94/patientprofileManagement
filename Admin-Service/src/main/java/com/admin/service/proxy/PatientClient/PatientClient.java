package com.admin.service.proxy.PatientClient;

import com.admin.service.model.modelProxy.patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient (url = "localhost:8083/patient",name = "Patient-Service")
public interface PatientClient {

    @GetMapping (path = "/all")
    List getAllPatient();

    @GetMapping (path = "/{id}")
    Object getPatientById (@PathVariable Long id);

    @GetMapping (path = "/search")
    Object getPatientName (@RequestParam (value = "name") String name);

    @PostMapping (path = "/save")
    Object createNewPatient (@RequestBody patient model);

    @PostMapping (path = "/update")
    Object updatePatient (@RequestBody patient model);
}
