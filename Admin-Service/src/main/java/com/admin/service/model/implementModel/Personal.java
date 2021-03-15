package com.admin.service.model.implementModel;

import com.admin.service.model.abstractbasic.AbstractModel;

public class Personal extends AbstractModel {

    private String fullname;
    private String dob;
    private String address;
    private String occupation;

    public Personal () {}

    public Personal (String fullname, String dob, String address, String occupation) {
        this.fullname = fullname;
        this.dob = dob;
        this.address = address;
        this.occupation = occupation;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
