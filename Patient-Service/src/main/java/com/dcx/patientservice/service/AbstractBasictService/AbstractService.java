package com.dcx.patientservice.service.AbstractBasictService;

import java.util.List;

public interface AbstractService<T> {

    List<T> findPatientAll();

    T findPatientById (Long Id);

    List<T> findByRecordId (String name);

    T save (T model);

    T update (T model);

    T remove( Long Id);

}
