package com.example.pushtest;

import androidx.annotation.NonNull;

class TestPushDataBuilderImpl implements TestPushDataBuilder {

    private String id;
    private String serialNumber;
    private String title;
    private String body;
    private PushType pushType;
    private long dateTime;
    private String username;

    @Override
    public TestPushDataBuilder setValidDefaultData(@NonNull PushType type) {
        this.id = "defaultId";
        this.serialNumber = "TR0815";
        this.title = "Default Title";
        this.body = "This is the default body";
        this.dateTime = System.currentTimeMillis();
        this.pushType = type;
        this.username = "U.User";
        return this;
    }

    @Override
    public TestPushDataBuilder setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    @Override
    public TestPushDataBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public PushData build() {
        return new PushData(id, serialNumber, title, body, pushType, dateTime, username);
    }
}
