package com.example.mcaadmissionhelp.database;

public class College {
    private int Id;
    private String CollegeName;
    private String Intake;
    private String Type;


    public College(int id, String collegeName, String intake, String type) {
        Id = id;
        CollegeName = collegeName;
        Intake = intake;
        Type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getIntake() {
        return Intake;
    }

    public void setIntake(String intake) {
        Intake = intake;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
