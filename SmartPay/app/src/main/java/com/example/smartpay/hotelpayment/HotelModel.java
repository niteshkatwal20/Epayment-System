package com.example.smartpay.hotelpayment;

public class HotelModel {
    String id, hotelName, guestName, hotelBillno, roomNo, noOfperson, hotelBillamount, guestNumber;

    public HotelModel() {
    }

    public HotelModel(String id, String hotelName, String guestName, String hotelBillno, String roomNo, String noOfperson, String hotelBillamount, String guestNumber) {
        this.id = id;
        this.hotelName = hotelName;
        this.guestName = guestName;
        this.hotelBillno = hotelBillno;
        this.roomNo = roomNo;
        this.noOfperson = noOfperson;
        this.hotelBillamount = hotelBillamount;
        this.guestNumber = guestNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getHotelBillno() {
        return hotelBillno;
    }

    public void setHotelBillno(String hotelBillno) {
        this.hotelBillno = hotelBillno;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getNoOfperson() {
        return noOfperson;
    }

    public void setNoOfperson(String noOfperson) {
        this.noOfperson = noOfperson;
    }

    public String getHotelBillamount() {
        return hotelBillamount;
    }

    public void setHotelBillamount(String hotelBillamount) {
        this.hotelBillamount = hotelBillamount;
    }

    public String getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(String guestNumber) {
        this.guestNumber = guestNumber;
    }
}
