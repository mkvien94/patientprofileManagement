package com.admin.service.model.modelProxy;

import com.admin.service.model.abstractbasic.AbstractModel;

public class patient extends AbstractModel {

    private String recordId;
    private String fullname;
    private String dob;
    private String address;
    private String diseasename;
    private String medicalname;
    private String Strength;
    private String beginDate;
    private String endDate;
    private String xRay;
    private String result;

    public patient() {}

    public patient(String recordId, String fullname, String dob, String address, String diseasename,
                   String medicalname, String strength, String beginDate, String endDate, String xRay,
                   String result) {
        this.recordId = recordId;
        this.fullname = fullname;
        this.dob = dob;
        this.address = address;
        this.diseasename = diseasename;
        this.medicalname = medicalname;
        this.Strength = strength;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.result = result;
    }

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
