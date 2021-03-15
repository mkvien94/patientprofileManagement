package com.admin.service.entity.ImplementEntity;

import com.admin.service.entity.AbstractEntity.AbstractBasicEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "personal")
public class PersonEntity extends AbstractBasicEntity {
    @Column
    private String fullname;
    @Column
    private String dob;
    @Column
    private String address;
    @Column
    private String occupation;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
