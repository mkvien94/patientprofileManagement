package com.admin.service.proxy.PatientClient;

import com.admin.service.model.modelProxy.medical;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient ( url = "localhost:8082/medical", name = "medical-service")
public interface medicalClient {

    @GetMapping (path = "/all")
    List getAllMedical();

    @GetMapping (path = "/{id}")
    Object getMedicalById(@PathVariable Long id);

    @PostMapping (path = "/save")
    Object createNewMedical (@RequestBody medical model);

    @PostMapping (path = "/update")
    Object updateMedical (@RequestBody medical model);

}
