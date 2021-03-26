package com.example.smartpay.electricitypayment;

public class ElectricityModel {
    String id, eleCustomerName, eLeCustomerId, eleAmount, eleDepositerName, eleDepositerNumber;

    public ElectricityModel() {
    }

    public ElectricityModel(String id, String eleCustomerName, String eLeCustomerId, String eleAmount, String eleDepositerName, String eleDepositerNumber) {
        this.id = id;
        this.eleCustomerName = eleCustomerName;
        this.eLeCustomerId = eLeCustomerId;
        this.eleAmount = eleAmount;
        this.eleDepositerName = eleDepositerName;
        this.eleDepositerNumber = eleDepositerNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEleCustomerName() {
        return eleCustomerName;
    }

    public void setEleCustomerName(String eleCustomerName) {
        this.eleCustomerName = eleCustomerName;
    }

    public String geteLeCustomerId() {
        return eLeCustomerId;
    }

    public void seteLeCustomerId(String eLeCustomerId) {
        this.eLeCustomerId = eLeCustomerId;
    }

    public String getEleAmount() {
        return eleAmount;
    }

    public void setEleAmount(String eleAmount) {
        this.eleAmount = eleAmount;
    }

    public String getEleDepositerName() {
        return eleDepositerName;
    }

    public void setEleDepositerName(String eleDepositerName) {
        this.eleDepositerName = eleDepositerName;
    }

    public String getEleDepositerNumber() {
        return eleDepositerNumber;
    }

    public void setEleDepositerNumber(String eleDepositerNumber) {
        this.eleDepositerNumber = eleDepositerNumber;
    }
}
