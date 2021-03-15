package com.admin.service.entity.ImplementEntity;

import com.admin.service.entity.AbstractEntity.AbstractBasicEntity;

import javax.persistence.*;

@Entity
@Table (name = "account")
public class AccountEntity extends AbstractBasicEntity {

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private boolean status;
    @OneToOne
    @JoinColumn (name = "person_id")
    private PersonEntity person;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
