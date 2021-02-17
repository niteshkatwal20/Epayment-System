package com.example.smartpay.tvpayment;

public class TvModel {
    String id, customerName, customerId, Tvamount, tvDepositername, tvDepositorNo;

    public TvModel() {
    }

    public TvModel(String id, String customerName, String customerId, String tvamount, String tvDepositername, String tvDepositorNo) {
        this.id = id;
        this.customerName = customerName;
        this.customerId = customerId;
        Tvamount = tvamount;
        this.tvDepositername = tvDepositername;
        this.tvDepositorNo = tvDepositorNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTvamount() {
        return Tvamount;
    }

    public void setTvamount(String tvamount) {
        Tvamount = tvamount;
    }

    public String getTvDepositername() {
        return tvDepositername;
    }

    public void setTvDepositername(String tvDepositername) {
        this.tvDepositername = tvDepositername;
    }

    public String getTvDepositorNo() {
        return tvDepositorNo;
    }

    public void setTvDepositorNo(String tvDepositorNo) {
        this.tvDepositorNo = tvDepositorNo;
    }
}
