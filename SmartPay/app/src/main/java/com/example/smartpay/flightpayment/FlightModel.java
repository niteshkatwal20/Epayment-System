package com.example.smartpay.flightpayment;

public class FlightModel {
    String id, flightFrom, flightTo, flightDate, fLightPassangerNo, flightPassangerName, flightNo, flightTicketNo, flightAmount;

    public FlightModel() {
    }

    public FlightModel(String id, String flightFrom, String flightTo, String flightDate, String fLightPassangerNo, String flightPassangerName, String flightNo, String flightTicketNo, String flightAmount) {
        this.id = id;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.flightDate = flightDate;
        this.fLightPassangerNo = fLightPassangerNo;
        this.flightPassangerName = flightPassangerName;
        this.flightNo = flightNo;
        this.flightTicketNo = flightTicketNo;
        this.flightAmount = flightAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getfLightPassangerNo() {
        return fLightPassangerNo;
    }

    public void setfLightPassangerNo(String fLightPassangerNo) {
        this.fLightPassangerNo = fLightPassangerNo;
    }

    public String getFlightPassangerName() {
        return flightPassangerName;
    }

    public void setFlightPassangerName(String flightPassangerName) {
        this.flightPassangerName = flightPassangerName;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightTicketNo() {
        return flightTicketNo;
    }

    public void setFlightTicketNo(String flightTicketNo) {
        this.flightTicketNo = flightTicketNo;
    }

    public String getFlightAmount() {
        return flightAmount;
    }

    public void setFlightAmount(String flightAmount) {
        this.flightAmount = flightAmount;
    }
}
