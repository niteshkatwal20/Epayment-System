package com.example.smartpay.databse;

public class AddMoneyData {
    public String id, addMoneyAccount, addMoneyBankname, addMoneyAmount,addMoneyRemarks;

    public AddMoneyData() {

    }

    public AddMoneyData(String id, String addMoneyAccount, String addMoneyBankname, String addMoneyAmount, String addMoneyRemarks) {
        this.id = id;
        this.addMoneyAccount = addMoneyAccount;
        this.addMoneyBankname = addMoneyBankname;
        this.addMoneyAmount = addMoneyAmount;
        this.addMoneyRemarks = addMoneyRemarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddMoneyAccount() {
        return addMoneyAccount;
    }

    public void setAddMoneyAccount(String addMoneyAccount) {
        this.addMoneyAccount = addMoneyAccount;
    }

    public String getAddMoneyBankname() {
        return addMoneyBankname;
    }

    public void setAddMoneyBankname(String addMoneyBankname) {
        this.addMoneyBankname = addMoneyBankname;
    }

    public String getAddMoneyAmount() {
        return addMoneyAmount;
    }

    public void setAddMoneyAmount(String addMoneyAmount) {
        this.addMoneyAmount = addMoneyAmount;
    }

    public String getAddMoneyRemarks() {
        return addMoneyRemarks;
    }

    public void setAddMoneyRemarks(String addMoneyRemarks) {
        this.addMoneyRemarks = addMoneyRemarks;
    }
}
