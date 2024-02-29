package com.example.pushtest;

import static com.example.pushtest.PushAdapter.receivePushFromProvider;

import android.os.storage.StorageManager;

import java.util.ArrayList;
import java.util.Comparator;

public class PushHandler {

    PushHandler(StorageManager storageManager) {
        mStorageManager = storageManager;
    }

    StorageManager mStorageManager;

    Boolean registrationDone = null;

    public ArrayList<PushData> getNotifications() {
        ArrayList<PushData> receivedPushList = receivePushFromProvider();
        return orderNotifications(receivedPushList);
    }

    private ArrayList<PushData> orderNotifications(ArrayList<PushData> pushList) {
        if (pushList != null && !pushList.isEmpty()) {
            ArrayList<PushData> orderedList = new ArrayList<>(pushList);
            orderedList.sort(new Comparator<PushData>() {
                @Override
                public int compare(PushData o1, PushData o2) {
                    return Long.compare(o2.getDateTime(), o1.getDateTime());
                }
            });
            return orderedList;
        } else {
            return pushList;
        }
    }

    public Boolean handlePush(PushData pushData) {
        return switch (pushData.getPushType()) {
            case Login -> handleLoginPush(pushData);
            case Transaction -> handleTransactionPush(pushData);
            case Registration -> handleRegistrationPush(pushData);
            case UNDEFINED -> handleUndefinedPush(pushData);
        };
    }


    public Boolean handleLoginPush(PushData pushData) {
        if (pushData.isValidLogin()) {
            // Navigate to the login screen.
            System.out.println(pushData.getPushType());
            return true;
        } else return false;
    }

    public Boolean handleTransactionPush(PushData pushData) {
        if (pushData.isValidTransaction()) {
            // Navigate to the transaction screen.
            System.out.println(pushData.getPushType());
            return true;
        }
        return false;
    }

    private Boolean handleRegistrationPush(PushData pushData) {
        if (pushData.isValidRegistration()) {
            // Navigate to the registration screen.
            System.out.println(pushData.getPushType());
            registrationDone = true;
            return true;
        } else {
            registrationDone = false;
            return false;
        }
    }

    private Boolean handleUndefinedPush(PushData pushData) {
        // Notify the user through a dialog window, showing the push body.
        DialogWindow dialogWindow = new DialogWindow(pushData.getTitle(), pushData.getBody());
        dialogWindow.showDialogWindow();
        System.out.println(pushData.getPushType());
        return false;
    }


}
