package com.admin.service.service.AbstractBasicService;





import java.util.List;


public interface AbstractService<T> {

    List<T> getAll ();

    T findById (Long id);

    T findByName (String name);

    List<T> findAllName (String name);

    T insert (T model);

    T update (T model);

    T remove (Long id);
}
