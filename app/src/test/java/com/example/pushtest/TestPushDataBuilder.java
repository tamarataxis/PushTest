package com.example.pushtest;

import androidx.annotation.NonNull;

interface TestPushDataBuilder {

    TestPushDataBuilder setValidDefaultData(@NonNull PushType type);

    TestPushDataBuilder setSerialNumber(String serialNumber);

    TestPushDataBuilder setUsername(String username);

    PushData build();

}