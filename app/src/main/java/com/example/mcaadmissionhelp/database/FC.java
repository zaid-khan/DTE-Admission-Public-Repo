package com.example.mcaadmissionhelp.database;

public class FC {
    private int Id;
    private String Code;
    private String Address;
    private String HowToReach;
    private String CollegeName;
    private String City;

    public FC(int id, String code, String address, String howToReach, String collegeName, String city) {
        Id = id;
        Code = code;
        Address = address;
        HowToReach = howToReach;
        CollegeName = collegeName;
        City = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getHowToReach() {
        return HowToReach;
    }

    public void setHowToReach(String howToReach) {
        HowToReach = howToReach;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}

