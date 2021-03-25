package com.admin.service.service.ImplementServices;

import com.admin.service.entity.ImplementEntity.AccountEntity;
import com.admin.service.entity.ImplementEntity.PersonEntity;
import com.admin.service.repository.AccountRepository;
import com.admin.service.service.AbstractBasicService.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AbstractService<AccountEntity> {

    @Autowired
    private AccountRepository repository;

    @Transactional(readOnly = true)
    public String validate(String username, String password) {
        AccountEntity accountEntity = repository.findByUsernameAndPassword(username, password);
        if (accountEntity == null) {
            throw new RuntimeException("Account not found");
        }
        return "{\"role\":\"" + accountEntity.getRole() + "\",\"code\":\"" + accountEntity.getId() + "\"}";
    }

    @Override
    public List<AccountEntity> getAll() {
        List<AccountEntity> list = repository.findAll();
        return list.isEmpty() ? null : list;
    }

    @Override
    public AccountEntity findById(Long id) {
        Optional<AccountEntity> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public AccountEntity findByName(String name) {
        AccountEntity user = repository.findByUsername(name);
        return user;
    }

    @Override
    public List<AccountEntity> findAllName(String name) {
        return null;
    }

    @Override
    public AccountEntity insert(AccountEntity model) {
        return null;
    }

    @Override
    public AccountEntity update(AccountEntity model) {
        return null;
    }

    @Override
    public AccountEntity remove(Long id) {

        try {
            //find account where need remove
            Optional<AccountEntity> optional = repository.findById(id);
            if (optional.isPresent()) {
                AccountEntity account = optional.get();
                account.setStatus(false);
                return repository.save(account);
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }

    }
}
