package com.example.smartpay.schoolfee;

public class SchoolModel {
    String id,schoolName,studentName,studentClass,billAmount,schooldepname,schooldepnum;

    public SchoolModel() {
    }

    public SchoolModel(String id, String schoolName, String studentName, String studentClass, String billAmount, String schooldepname, String schooldepnum) {
        this.id = id;
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.billAmount = billAmount;
        this.schooldepname = schooldepname;
        this.schooldepnum = schooldepnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getSchooldepname() {
        return schooldepname;
    }

    public void setSchooldepname(String schooldepname) {
        this.schooldepname = schooldepname;
    }

    public String getSchooldepnum() {
        return schooldepnum;
    }

    public void setSchooldepnum(String schooldepnum) {
        this.schooldepnum = schooldepnum;
    }
}
