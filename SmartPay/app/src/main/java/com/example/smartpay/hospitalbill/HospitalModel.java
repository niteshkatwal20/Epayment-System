package com.example.smartpay.hospitalbill;

public class HospitalModel {
    String id, hospitalname, patientname, hospitalbillno, hospitalbillamount;

    public HospitalModel() {
    }

    public HospitalModel(String id, String hospitalname, String patientname, String hospitalbillno, String hospitalbillamount) {
        this.id = id;
        this.hospitalname = hospitalname;
        this.patientname = patientname;
        this.hospitalbillno = hospitalbillno;
        this.hospitalbillamount = hospitalbillamount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getHospitalbillno() {
        return hospitalbillno;
    }

    public void setHospitalbillno(String hospitalbillno) {
        this.hospitalbillno = hospitalbillno;
    }

    public String getHospitalbillamount() {
        return hospitalbillamount;
    }

    public void setHospitalbillamount(String hospitalbillamount) {
        this.hospitalbillamount = hospitalbillamount;
    }
}
