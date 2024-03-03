package com.example.pushtest;

import android.os.storage.StorageManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PushHandlerTest {

    private final StorageManager mStorageManager = null;

    @Test
    public void givenLoginPushDataValid_handlePush_ReturnsTrue() {
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
    public void givenLoginPushDataWithInvalidUser_handlePush_ReturnsFalse() {
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
    public void givenLoginPushDataWithNullUser_handlePush_ReturnsFalse() {
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
    public void givenTransactionPushDataValid_handlePush_ReturnsTrue() {
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
    public void givenTransactionPushDataWithInvalidSerialNumber_handlePush_ReturnsFalse() {
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
    public void givenTransactionPushDataWithNullSerialNumber_handlePush_ReturnsFalse() {
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
    public void givenRegistrationPushDataValid_handlePush_ReturnsTrue() {
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
    public void givenRegistrationPushDataWithInvalidUser_handlePush_ReturnsFalse() {
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
    public void givenRegistrationPushDataWithNullUser_handlePush_ReturnsFalse() {
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
    public void givenUndefinedPushData_handlePush_ReturnsFalse() {
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