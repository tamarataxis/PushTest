package com.example.pushtest;

import android.os.storage.StorageManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PushHandlerTest {

    private final StorageManager mStorageManager = null;

    @Test
    public void givenValidLoginPushData_handlePush_ReturnsTrue() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Login)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertTrue(result);
    }

    @Test
    public void givenInvalidLoginUser_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Login)
                .setUsername("Invalid User")
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
    }

    @Test  // TODO: Null values are not handled! Use @NotNull annotation and delete test?
    public void givenNullPushData_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = null;

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
    }

    @Test
    public void givenNullUserLoginPushData_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Login)
                .setUsername(null)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
    }

    @Test
    public void givenValidTransactionPushData_handlePush_ReturnsTrue() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Transaction)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertTrue(result);
    }

    @Test
    public void givenInvalidTransactionSerialNumber_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Transaction)
                .setSerialNumber("Invalid number")
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
    }

    @Test // TODO: Null values are not handled! Use @NotNull annotation and delete test?
    public void givenNullTransactionSerialNumber_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Transaction)
                .setSerialNumber(null)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
    }

    @Test
    public void givenValidRegistrationPushData_handlePush_ReturnsTrue() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Registration)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertTrue(result);
        assertTrue(handler.registrationDone);
    }

    @Test
    public void givenInvalidRegistrationUser_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Registration)
                .setUsername("Invalid User")
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
        assertFalse(handler.registrationDone);
    }

    @Test
    public void givenNullRegistrationUser_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.Registration)
                .setUsername(null)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
        assertFalse(handler.registrationDone);
    }

    @Test
    public void givenValidUndefinedPushData_handlePush_ReturnsFalse() {
        // given
        PushHandler handler = new PushHandler(mStorageManager);
        PushData data = new TestPushDataBuilderImpl()
                .setValidDefaultData(PushType.UNDEFINED)
                .build();

        // when
        Boolean result = handler.handlePush(data);

        // then
        assertFalse(result);
    }

}