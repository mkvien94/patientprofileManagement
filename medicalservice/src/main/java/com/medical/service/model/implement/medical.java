package com.medical.service.model.implement;

import com.medical.service.model.AbstactBasicModel.AbstractModel;

public class medical extends AbstractModel {

    private String medicalName;
    private String type;
    private Integer amount;
    private Double price;
    private String beginImport;

    public medical () {}

    public  medical (String medicalName, String type, Integer amount, Double price, String beginImport) {
        this.medicalName = medicalName;
        this.type = type;
        this.amount = amount;
        this.price = price;
        this.beginImport = beginImport;
    }

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
