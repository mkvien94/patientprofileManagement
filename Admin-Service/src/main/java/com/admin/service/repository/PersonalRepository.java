package com.admin.service.repository;

import com.admin.service.entity.ImplementEntity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findByFullname (String fullname);
}
