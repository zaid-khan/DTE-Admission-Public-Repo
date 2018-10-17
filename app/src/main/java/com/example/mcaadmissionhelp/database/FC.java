package com.example.mcaadmissionhelp.database;

public class FC {
    private int id;
    private String code;
    private String address;
    private String reach;
    private String collegeName;
    private String city;

    public FC(int id, String code, String address, String reach, String collegeName, String city) {
        this.id = id;
        this.code = code;
        this.address = address;
        this.reach = reach;
        this.collegeName = collegeName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
