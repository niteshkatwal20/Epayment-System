package com.example.smartpay.recharge;

public class RechargeModel {

    String id, rechargeMobileNo, rechageAmount;

    public RechargeModel() {
    }

    public RechargeModel(String id, String rechargeMobileNo, String rechageAmount) {
        this.id = id;
        this.rechargeMobileNo = rechargeMobileNo;
        this.rechageAmount = rechageAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRechargeMobileNo() {
        return rechargeMobileNo;
    }

    public void setRechargeMobileNo(String rechargeMobileNo) {
        this.rechargeMobileNo = rechargeMobileNo;
    }

    public String getRechageAmount() {
        return rechageAmount;
    }

    public void setRechageAmount(String rechageAmount) {
        this.rechageAmount = rechageAmount;
    }
}
