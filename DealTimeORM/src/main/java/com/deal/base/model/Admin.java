package com.deal.base.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Admin implements Serializable {

    private long adminId;
    private String adminEmail;
    private String adminPassword;
    private String adminFirstName;
    private String adminLastName;
    private String adminAddress;
    private String adminJob;
    private String adminPhoneNo;
    private LocalDate adminDateOfBirth;

    public Admin() {
    }

    public Admin(String adminEmail, String adminPassword, String adminPhoneNo,
            String adminFirstName, String adminLastName) {
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminPhoneNo = adminPhoneNo;
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
    }

    public Admin(String adminEmail, String adminPassword, String adminFirstName, String adminLastName, 
            String adminAddress, String adminJob, String adminPhoneNo, LocalDate adminDateOfBirth) {
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.adminAddress = adminAddress;
        this.adminJob = adminJob;
        this.adminPhoneNo = adminPhoneNo;
        this.adminDateOfBirth = adminDateOfBirth;
    }
    
    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminJob() {
        return adminJob;
    }

    public void setAdminJob(String adminJob) {
        this.adminJob = adminJob;
    }

    public String getAdminPhoneNo() {
        return adminPhoneNo;
    }

    public void setAdminPhoneNo(String adminPhoneNo) {
        this.adminPhoneNo = adminPhoneNo;
    }

    public LocalDate getAdminDateOfBirth() {
        return adminDateOfBirth;
    }

    public void setAdminDateOfBirth(LocalDate adminDateOfBirth) {
        this.adminDateOfBirth = adminDateOfBirth;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + ", adminFirstName=" + adminFirstName + ", adminLastName=" + adminLastName + ", adminAddress=" + adminAddress + ", adminJob=" + adminJob + ", adminPhoneNo=" + adminPhoneNo + ", adminDateOfBirth=" + adminDateOfBirth + '}';
    }

}
