package com.example.pushtest;

import java.util.ArrayList;

public class PushAdapter {

    public static ArrayList<PushData> receivePushFromProvider() {
        PushData testPushLogin = new PushData(
                "Test id ",
                "Test serial",
                "Test title",
                "Test body",
                PushType.Login,
                System.currentTimeMillis(),
                "U1234"
        );

        PushData testPushRegistration = new PushData(
                "Test id ",
                "Test serial",
                "Test title",
                "Test body",
                PushType.Registration,
                System.currentTimeMillis(),
                "U2345"
        );

        ArrayList<PushData> pushList = new ArrayList<PushData>();
        pushList.add(testPushLogin);
        pushList.add(testPushRegistration);
        return pushList;
    }

}
