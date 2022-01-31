package com.freshchat.consumer.sdk.j;

import android.content.Context;

public class cw {

    /* renamed from: ir  reason: collision with root package name */
    private static final a f594ir = a.ANDROID;

    public enum a {
        ANDROID("android"),
        FLUTTER("flutter"),
        REACT_NATIVE("reactnative"),
        PHONEGAP("phonegap");
        
        public String name;

        private a(String str) {
            this.name = str;
        }
    }

    public static String bu(Context context) {
        try {
            if (ao.u(context, "com.freshchat.consumer.sdk.flutter.FreshchatSdkPlugin") != null) {
                return a.FLUTTER.name;
            }
            if (ao.u(context, "com.freshchat.consumer.sdk.react.RNFreshchatSdk") != null) {
                return a.REACT_NATIVE.name;
            }
            if (ao.u(context, "com.freshdesk.freshchat.android.freshchatPlugin") != null) {
                return a.PHONEGAP.name;
            }
            return f594ir.name;
        } catch (Exception e) {
            q.a(e);
        }
    }
}
