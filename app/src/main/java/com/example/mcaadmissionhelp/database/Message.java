package com.example.mcaadmissionhelp.database;

public class Message {

    private String data;
    private int FromUser;

    public Message() {
    }

    public Message(String message, int fromUser) {
        data = message;
        FromUser = fromUser;
    }

    public String getMessage() {
        return data;
    }

    public void setMessage(String message) {
        data = message;
    }

    public int getFromUser() {
        return FromUser;
    }

    public void setFromUser(int fromUser) {
        FromUser = fromUser;
    }
}
