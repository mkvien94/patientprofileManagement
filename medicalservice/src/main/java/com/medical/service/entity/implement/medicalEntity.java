package com.medical.service.entity.implement;

import com.medical.service.entity.AbstractbasicEntity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table (name = "medical")
public class medicalEntity extends AbstractEntity {

    @Column
    private String medicalName;
    @Column
    private String type;
    @Column
    private Integer amount;
    @Column
    private Double price;
    @Column
    private String beginImport;

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBeginImport() {
        return beginImport;
    }

    public void setBeginImport(String beginImport) {
        this.beginImport = beginImport;
    }
}
