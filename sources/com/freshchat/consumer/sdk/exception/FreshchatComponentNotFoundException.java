package com.freshchat.consumer.sdk.exception;

public class FreshchatComponentNotFoundException extends RuntimeException {
    public FreshchatComponentNotFoundException(String str) {
        super(hj1.T("Component of Freshchat SDK not found in your app's AndroidManifest.xml + (", str, " missing!)"));
    }
}
