package com.medical.service.service.AbstractService;

import java.util.List;

public interface AbstractBasicService<T> {

    List<T> getAllMedical();

    List<T> findByName (String name);

    T findById (Long id);

    T insert (T model);

    T update (T model);

    T remove (T model);
}
