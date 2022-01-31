package com.freshchat.consumer.sdk.exception;

public class PermissionNotGrantedException extends SecurityException {
    public PermissionNotGrantedException(String str) {
        super(hj1.T("Permission required by Freshchat SDK not granted (Is ", str, " permission present in your manifest? )"));
    }
}
