package com.deal.base.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {

    private long custId;
    private String custEmail;
    private String custPassword;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custJob;
    private String custMobileNumber;
    private LocalDate custDateOfBirth;
    private double custCreditLimit;
    private String custWishList;

    public Customer() {
    }

    public Customer(String custEmail, String custPassword, String custFirstName, String custLastName,
            String custMobileNumber, double custCreditLimit) {
        this.custEmail = custEmail;
        this.custPassword = custPassword;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custMobileNumber = custMobileNumber;
        this.custCreditLimit = custCreditLimit;
    }
    
    public Customer(String custEmail, String custPassword, String custFirstName, String custLastName, String custAddress, 
            String custJob, String custMobileNumber, LocalDate custDateOfBirth, double custCreditLimit, String custWishList) {
        this.custEmail = custEmail;
        this.custPassword = custPassword;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custAddress = custAddress;
        this.custJob = custJob;
        this.custMobileNumber = custMobileNumber;
        this.custDateOfBirth = custDateOfBirth;
        this.custCreditLimit = custCreditLimit;
        this.custWishList = custWishList;
    }

    public Customer(long custId) {
        this.custId = custId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustJob() {
        return custJob;
    }

    public void setCustJob(String custJob) {
        this.custJob = custJob;
    }

    public LocalDate getCustDateOfBirth() {
        return custDateOfBirth;
    }

    public void setCustDateOfBirth(LocalDate custDateOfBirth) {
        this.custDateOfBirth = custDateOfBirth;
    }

    public double getCustCreditLimit() {
        return custCreditLimit;
    }

    public void setCustCreditLimit(double custCreditLimit) {
        this.custCreditLimit = custCreditLimit;
    }

    public String getCustWishList() {
        return custWishList;
    }

    public void setCustWishList(String custWishList) {
        this.custWishList = custWishList;
    }

    public String getCustMobileNumber() {
        return custMobileNumber;
    }

    public void setCustMobileNumber(String custMobileNumber) {
        this.custMobileNumber = custMobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "custId=" + custId + ", custEmail=" + custEmail + ", custPassword=" + custPassword + ", custFirstName=" + custFirstName + ", custLastName=" + custLastName + ", custAddress=" + custAddress + ", custJob=" + custJob + ", custMobileNumber=" + custMobileNumber + ", custDateOfBirth=" + custDateOfBirth + ", custCreditLimit=" + custCreditLimit + ", custWishList=" + custWishList + '}';
    }

}