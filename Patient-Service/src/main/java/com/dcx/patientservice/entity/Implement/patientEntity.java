package com.dcx.patientservice.entity.Implement;

import com.dcx.patientservice.entity.AbstractBasicEntity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "patient")
public class patientEntity extends AbstractEntity {
    @Column
    private String recordId;
    @Column
    private String fullname;
    @Column
    private String dob;
    @Column
    private String address;
    @Column
    private String diseasename;
    @Column
    private String medicalname;
    @Column
    private String Strength;
    @Column
    private String beginDate;
    @Column
    private String endDate;
    @Column
    private String xRay;
    @Column
    private String result;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

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

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    public String getMedicalname() {
        return medicalname;
    }

    public void setMedicalname(String medicalname) {
        this.medicalname = medicalname;
    }

    public String getStrength() {
        return Strength;
    }

    public void setStrength(String strength) {
        Strength = strength;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getxRay() {
        return xRay;
    }

    public void setxRay(String xRay) {
        this.xRay = xRay;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
