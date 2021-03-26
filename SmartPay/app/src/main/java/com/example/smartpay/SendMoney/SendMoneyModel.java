package com.example.smartpay.SendMoney;

public class SendMoneyModel {
    public String id,sendEmail,sendAmount,purpose,remarks;

    public SendMoneyModel() {
    }

    public SendMoneyModel(String id, String sendEmail, String sendAmount, String purpose, String remarks) {
        this.id = id;
        this.sendEmail = sendEmail;
        this.sendAmount = sendAmount;
        this.purpose = purpose;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(String sendAmount) {
        this.sendAmount = sendAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
