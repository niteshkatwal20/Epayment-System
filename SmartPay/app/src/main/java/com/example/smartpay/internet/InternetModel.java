package com.example.smartpay.internet;

public class InternetModel {
    String id, serviceProvider, ispClientName, ispClientId, internetBillPayment;

    public InternetModel() {
    }

    public InternetModel(String id, String serviceProvider, String ispClientName, String ispClientId, String internetBillPayment) {
        this.id = id;
        this.serviceProvider = serviceProvider;
        this.ispClientName = ispClientName;
        this.ispClientId = ispClientId;
        this.internetBillPayment = internetBillPayment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getIspClientName() {
        return ispClientName;
    }

    public void setIspClientName(String ispClientName) {
        this.ispClientName = ispClientName;
    }

    public String getIspClientId() {
        return ispClientId;
    }

    public void setIspClientId(String ispClientId) {
        this.ispClientId = ispClientId;
    }

    public String getInternetBillPayment() {
        return internetBillPayment;
    }

    public void setInternetBillPayment(String internetBillPayment) {
        this.internetBillPayment = internetBillPayment;
    }
}
