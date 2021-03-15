package com.admin.service.repository;

import com.admin.service.entity.ImplementEntity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByUsername (String username);
}
