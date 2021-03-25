package com.dcx.patientservice.service.AbstractBasictService;

import java.util.List;

public interface AbstractService<T> {

    List<T> findPatientAll();

    T findPatientById (Long Id);

    List<T> findByRecordId (String name);

    List<T> findByFullName(String name);

    List<T> findByDiseaseName (String name);

    List<T> findByMedicalName (String name);

    T save (T model);

    T update (T model);

    void remove( Long Id);

}
