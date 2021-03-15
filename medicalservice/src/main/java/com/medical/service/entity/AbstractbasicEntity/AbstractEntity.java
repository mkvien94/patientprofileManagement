package com.medical.service.entity.AbstractbasicEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity implements Persistable<Long>, Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return Id == null;
    }
}
