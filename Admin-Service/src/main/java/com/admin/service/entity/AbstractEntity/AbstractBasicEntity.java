package com.admin.service.entity.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractBasicEntity implements Persistable<Long>, Serializable {

    @javax.persistence.Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return Id == null;
    }
}
