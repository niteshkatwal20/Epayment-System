package com.example.smartpay.buspayment;

public class BusModel {
    public String id, from, to, passengername, busname, ticketno, depdate, passangerno,busfare;

    public BusModel() {
    }

    public BusModel(String id, String from, String to, String passengername, String busname, String ticketno, String depdate, String passangerno, String busfare) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.passengername = passengername;
        this.busname = busname;
        this.ticketno = ticketno;
        this.depdate = depdate;
        this.passangerno = passangerno;
        this.busfare = busfare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getDepdate() {
        return depdate;
    }

    public void setDepdate(String depdate) {
        this.depdate = depdate;
    }

    public String getPassangerno() {
        return passangerno;
    }

    public void setPassangerno(String passangerno) {
        this.passangerno = passangerno;
    }

    public String getBusfare() {
        return busfare;
    }

    public void setBusfare(String busfare) {
        this.busfare = busfare;
    }
}
