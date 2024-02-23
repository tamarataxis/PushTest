package com.example.pushtest;

public class PushData {

    private final String id;
    private final String serialNumber;
    private final String title;
    private final String body;
    private final PushType pushType;
    private final long dateTime;
    private final String username;

    public PushData(String id, String serialNumber, String title, String body, PushType pushType, long dateTime, String username) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.title = title;
        this.body = body;
        this.pushType = pushType;
        this.dateTime = dateTime;
        this.username = username;
    }

    public PushData(String id, String serialNumber, String title, String body, PushType pushType) {
        this(id, serialNumber, title, body, pushType, System.currentTimeMillis(), "");
    }
    public String getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public PushType getPushType() {
        return pushType;
    }

    public long getDateTime() {
        return dateTime;
    }
    public String getUser() {
        return username != null ? username : "";
    }

    public boolean isValidLogin(){
        return getPushType() == PushType.Login && getUser().startsWith("U");
    }

    public boolean isValidRegistration(){
        return getPushType() == PushType.Registration && getUser().startsWith("U");
    }

    public boolean isValidTransaction(){
        return getPushType() == PushType.Transaction && getSerialNumber().startsWith("TR");
    }

}