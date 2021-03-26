package com.example.smartpay.banktransfer;

public class BankTransferModel {
    public String id, bankname, bankaccountno, bankamount, bankdepositername, bankdepositernumber;

    public BankTransferModel() {
    }

    public BankTransferModel(String id, String bankname, String bankaccountno, String bankamount, String bankdepositername, String bankdepositernumber) {
        this.id = id;
        this.bankname = bankname;
        this.bankaccountno = bankaccountno;
        this.bankamount = bankamount;
        this.bankdepositername = bankdepositername;
        this.bankdepositernumber = bankdepositernumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccountno() {
        return bankaccountno;
    }

    public void setBankaccountno(String bankaccountno) {
        this.bankaccountno = bankaccountno;
    }

    public String getBankamount() {
        return bankamount;
    }

    public void setBankamount(String bankamount) {
        this.bankamount = bankamount;
    }

    public String getBankdepositername() {
        return bankdepositername;
    }

    public void setBankdepositername(String bankdepositername) {
        this.bankdepositername = bankdepositername;
    }

    public String getBankdepositernumber() {
        return bankdepositernumber;
    }

    public void setBankdepositernumber(String bankdepositernumber) {
        this.bankdepositernumber = bankdepositernumber;
    }

}
